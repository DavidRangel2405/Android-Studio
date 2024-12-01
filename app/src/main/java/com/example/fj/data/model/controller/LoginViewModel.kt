package com.example.fj.data.model.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fj.data.model.LoginRequest
import com.example.fj.data.model.User
import com.example.fj.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel : ViewModel() {

    // Estado del login observable por la UI
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    // Función para iniciar sesión
    fun login(username: String, password: String) {
        _loginState.value = LoginState.Loading // Indicar que el proceso ha iniciado

        viewModelScope.launch {
            try {
                // Llamada a la API
                val response = RetrofitClient.api.login(LoginRequest(username, password))

                if (response.isSuccessful) {
                    val body = response.body()

                    // Verificar si el login fue exitoso
                    if (body != null && body.login == "success" && body.user.isNotEmpty()) {
                        _loginState.value = LoginState.Success(body.user[0]) // Usuario válido
                    } else {
                        _loginState.value = LoginState.Error("Credenciales incorrectas") // Usuario o contraseña incorrectos
                    }
                } else {
                    _loginState.value = LoginState.Error("Enter username and password") // Error de respuesta
                }
            } catch (e: HttpException) {
                _loginState.value = LoginState.Error("Can't connect to the server") // Error en la red
            } catch (e: IOException) {
                _loginState.value = LoginState.Error("There is no internet connection") // Problema de conexión
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("Unknown error") // Otros errores
            }
        }
    }
}

// Estados posibles del proceso de login
sealed class LoginState {
    data object Idle : LoginState() // Estado inicial
    data object Loading : LoginState() // Mientras se procesa el login
    data class Success(val user: User) : LoginState() // Login exitoso
    data class Error(val message: String) : LoginState() // Error en el login
}
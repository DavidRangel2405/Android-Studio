package com.example.fj.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import coil.compose.AsyncImage

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color(0xFF121212)) // Fondo más oscuro para resaltar los elementos
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LoginForm(navController)
    }
}

//@Preview(showBackground = true)
@Composable
fun LoginForm(navController: NavController) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Card(
        colors = CardDefaults.cardColors(
            contentColor = Color(0xFFF5F5F5),  // Texto en color claro
            containerColor = Color(0xFF1E1E1E) // Fondo gris oscuro para la tarjeta
        ),
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 16.dp) // Más espacio horizontal
    ) {
        Column(
            modifier = Modifier.padding(24.dp) // Aumenta el padding interno
        ) {
            AsyncImage(
                model = "https://i.pinimg.com/564x/6e/39/83/6e3983ef421a6536731ab1123d847d60.jpg",
                contentDescription = "Github Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp) // Espacio debajo de la imagen
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp), // Espaciado entre campos
                value = user,
                maxLines = 1,
                onValueChange = { user = it },
                label = { Text("User", color = Color(0xFFB0BEC5)) } // Color más claro en la etiqueta
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                value = password,
                maxLines = 1,
                onValueChange = { password = it },
                label = { Text("Password", color = Color(0xFFB0BEC5)) },
                visualTransformation = PasswordVisualTransformation()
            )
            FilledTonalButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF64B5F6), // Botón azul para llamar la atención
                    contentColor = Color.White
                ),
                onClick = { /* Acción de inicio de sesión */ }
            ) {
                Text("LOG IN")
            }
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFF64B5F6) // Color del texto en azul
                ),
                border = BorderStroke(1.dp, Color(0xFF64B5F6)),
                onClick = { navController.navigate("home") }
            ) {
                Text("CREATE AN ACCOUNT")
            }
        }
    }
}

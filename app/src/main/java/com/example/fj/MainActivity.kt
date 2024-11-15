package com.example.fj

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fj.ui.screens.HomeScreen
import com.example.fj.ui.screens.MenuScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fj.ui.screens.BiometricsScreen
import com.example.fj.ui.screens.SegundoPlanoScreen
import com.example.fj.ui.screens.ComponentsScreen
import com.example.fj.ui.screens.ContactCalendarScreen
import com.example.fj.ui.screens.LocalizacionScreen
import com.example.fj.ui.screens.LoginScreen
import com.example.fj.ui.screens.WifiDatosScreen

//import androidx.navigation.compose.NavHostController

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposeMultiScreenApp()
        }
    }
}

@Composable
fun ComposeMultiScreenApp() {
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("components") { ComponentsScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("segundoplano") { SegundoPlanoScreen() }
        composable("localizacion") { LocalizacionScreen(viewModel()) }
        composable("contactcalendar") { ContactCalendarScreen() }
        composable("biometrics") { BiometricsScreen() }
        composable("wifidatos") {
            WifiDatosScreen(
                wifiManager = LocalContext.current.getSystemService(Context.WIFI_SERVICE) as WifiManager,
                connectivityManager = LocalContext.current.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager,
                context = LocalContext.current as ComponentActivity
            )
        }
    }
}
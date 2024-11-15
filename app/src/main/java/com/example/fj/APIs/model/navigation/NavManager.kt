package com.example.fj.APIs.model.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fj.APIs.model.viewModel.SearchViewModel
import com.example.fj.APIs.model.views.HomeView
import com.example.fj.APIs.model.views.MapsSearchView

@Composable
fun NavManager(searchVM: SearchViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        //Rutas
        composable("Home") {
            HomeView(navController, searchVM)
        }
        // Ruta para `MapsSearchView` que recibe latitud, longitud y dirección como argumentos
        composable("MapsSearchView/{lat}/{long}/{address}", arguments = listOf(
            navArgument("lat") { type = NavType.FloatType },
            navArgument("long") { type = NavType.FloatType },
            navArgument("address") { type = NavType.StringType }
        )) {
            // Obtención de los argumentos con valores predeterminados en caso de que falten
            val lat = it.arguments?.getFloat("lat") ?: 0.0
            val long = it.arguments?.getFloat("long") ?: 0.0
            val address = it.arguments?.getString("address") ?: ""
            MapsSearchView(lat.toDouble(), long.toDouble(), address )
        }
    }
}

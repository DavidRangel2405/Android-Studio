package com.example.fj.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController){
    Column {
        Text(text = "This in the Menu Screen")
        Button(onClick = {navController.navigate("home")}) {
            
        }
    }
}
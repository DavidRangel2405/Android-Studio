package com.example.fj.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize( ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "This is the Menu Screen")
        Button(onClick = {navController.navigate("home")}) {
            Text("Go to Home")
        }
        Button(onClick = {navController.navigate("components")}) {
            Text("Go to Components")
        }
        Button(onClick = {navController.navigate("login")}) {
            Text("Go to Login")
        }
        Button(onClick = {navController.navigate("segundoplano")}) {
            Text("Go to Alarm")
        }
        Button(onClick = {navController.navigate("localizacion")}) {
            Text("Go to Localization")
        }
        Button(onClick = {navController.navigate("contactcalendar")}) {
            Text("Go to ContactCalendar")
        }
        Button(onClick = {navController.navigate("biometrics")}) {
            Text("Go to Biometrics")
        }
        Button(onClick = {navController.navigate("wifidatos")}) {
            Text("Go to Wifi-Datos")
        }
    }
}
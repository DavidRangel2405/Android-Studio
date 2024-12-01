package com.example.fj.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title:String, navController: NavController, backButton:Boolean){
    TopAppBar(
        colors = topAppBarColors(
            containerColor = Color(0xFF4F0417),
            titleContentColor = Color.White,
        ),
        title = {
            Text(title)
        },
        navigationIcon = {
            if (backButton) {
                IconButton(onClick = {
                    if (!navController.popBackStack()) {
                        navController.navigateUp() // Intenta navegar hacia atrás
                    }
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Go to previous screen",
                        tint = Color.White
                    )
                }
            }
        },
    )
}
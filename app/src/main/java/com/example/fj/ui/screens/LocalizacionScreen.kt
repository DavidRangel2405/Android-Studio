package com.example.fj.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fj.navigation.NavManager
import com.example.fj.ui.theme.FJTheme
import com.example.fj.viewModel.SearchViewModel

@Composable
fun LocalizacionScreen(viewModel: SearchViewModel) {
    FJTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavManager(viewModel)
        }
    }
}

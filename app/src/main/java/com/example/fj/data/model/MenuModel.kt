package com.example.fj.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuModel(
    val id: Int,
    val title:String,
    val option: String,
    val icon: ImageVector
)
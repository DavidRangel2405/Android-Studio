package com.example.fj.data.model

import androidx.compose.ui.graphics.painter.Painter

data class PostModel(
    val id:Int,
    var title:String,
    val text:String,
    val image:Painter
)

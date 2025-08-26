package com.example.kotlincoroutine

import java.io.Serializable

data class Category(
    val title: String,
    val subtitle: String,
    val imageResId: Int
) : Serializable
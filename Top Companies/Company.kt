package com.example.kotlincoroutine

import java.io.Serializable

data class Company(
    val name: String,
    val description: String,
    val price: String,
    val imageResId: Int
): Serializable
package com.d4c.assignment.models

data class Product(
    val imageRes: Int,
    val title: String,
    val description: String,
    val useCase: String,
    val skinType: String,
    val price: Float,
    val originalPrice: Float,
    val reviews: Int,
    val rating: Float,
    val bestSeller: Boolean,
    val inStock: Boolean,
    val isWishlisted: Boolean
)

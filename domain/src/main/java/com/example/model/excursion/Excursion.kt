package com.example.model

data class Excursion(
    val id: Int,
    val name: String,
    val distance: Float,
    val type: ExcursionType,
    val imageUrl: String,
    val description: String
)

enum class ExcursionType {
    WALKING, BICYCLE, CAR, COMBINE
}

package com.example.model.excursion

import com.example.model.ExcursionType
import com.example.model.GeoPosition

data class DetailedExcursion(
    val id: Int,
    val name: String,
    val distance: Float,
    val type: ExcursionType,
    val imageUrl: String,
    val description: String,
    val imagesUrl: List<String>,
    val walkingCoordinates: List<GeoPosition>,
    val bicycleCoordinates: List<GeoPosition>,
    val carCoordinates: List<GeoPosition>,
    val walkingTime: Time?,
    val bicycleTime: Time?,
    val carTime: Time?
)

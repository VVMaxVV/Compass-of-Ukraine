package com.example.model.excursion

import com.example.model.EventTime
import com.example.model.GeoPosition
import com.example.model.MediaLinks
import java.time.LocalDate

data class DetailedEvent(
    val id: Int,
    val title: String,
    val shortDescription: String,
    val dateStart: LocalDate,
    val dateFinish: LocalDate?,
    val eventTime: EventTime,
    val description: String,
    val coordinates: GeoPosition,
    val imagesUrl: List<String>,
    val mediaLinks: MediaLinks
)

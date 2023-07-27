package com.example.mock

import com.example.model.EventTime
import com.example.model.GeoPosition
import com.example.model.MediaLinks
import com.example.model.excursion.DetailedEvent
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.Month

internal class DetailsEventFactory {
    suspend fun get(id: Int): DetailedEvent {
        delay(1000)
        return DetailedEvent(
            id = id,
            title = "Kharkiv City Day",
            shortDescription = "Celebration",
            dateStart = LocalDate.of(2023, Month.AUGUST, 23),
            dateFinish = null,
            eventTime = EventTime.AllDay,
            description = "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows.\n" +
                "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows.",
            coordinates = GeoPosition(50.00457842801801, 36.233972769529544),
            mediaLinks = MediaLinks(),
            imagesUrl = listOf(
                "https://beket.com.ua/wp-content/uploads/_k/kharkov-01.jpg",
                "https://beket.com.ua/wp-content/uploads/_k/kharkov-01.jpg",
                "https://beket.com.ua/wp-content/uploads/_k/kharkov-01.jpg"
            )
        )
    }
}

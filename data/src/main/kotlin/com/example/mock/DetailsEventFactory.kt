package com.example.mock

import com.example.model.DetailedEvent
import com.example.model.EventTime
import com.example.model.GeoPosition
import com.example.model.MediaLinks
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
                "https://upload.wikimedia.org/wikipedia/commons/e/ee/%D0%9E%D1%81%D0%B5%D0%BD%D0%BD%D0%B8%D0%B9_%D0%B2%D0%BE%D0%BA%D0%B7%D0%B0%D0%BB.jpg",
                "https://azbyka.ru/palomnik/images/thumb/9/97/%D0%A5%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2_%D0%B2%D0%B8%D0%B4_%D0%BD%D0%B0_%D1%81%D0%BE%D0%B1%D0%BE%D1%80.jpg/300px-%D0%A5%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2_%D0%B2%D0%B8%D0%B4_%D0%BD%D0%B0_%D1%81%D0%BE%D0%B1%D0%BE%D1%80.jpg"
            )
        )
    }
}

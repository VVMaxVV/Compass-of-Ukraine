package com.example.repository

import com.example.model.DetailedEvent
import com.example.model.Event
import com.example.model.Location
import com.example.model.excursion.DetailedEvent

interface EventsRepository {
    suspend fun getEvents(location: Location): List<Event>
    suspend fun getDetailsEvent(id: Int): DetailedEvent
}

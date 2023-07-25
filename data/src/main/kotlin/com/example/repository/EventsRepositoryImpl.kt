package com.example.repository

import com.example.mock.DetailsEventFactory
import com.example.mock.EventsFactory
import com.example.model.DetailedEvent
import com.example.model.Event
import com.example.model.Location

internal class EventsRepositoryImpl(
    private val eventsFactory: EventsFactory,
    private val detailsEventFactory: DetailsEventFactory
) : EventsRepository {
    override suspend fun getEvents(location: Location): List<Event> = eventsFactory.get(location)

    override suspend fun getDetailsEvent(id: Int): DetailedEvent = detailsEventFactory.get(id)
}

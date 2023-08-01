package com.example.useCase.impl

import com.example.model.DetailedEvent
import com.example.repository.EventsRepository
import com.example.useCase.GetDetailsEventsUseCase

internal class GetDetailsEventsUseCaseImpl(
    private val eventsRepository: EventsRepository
) : GetDetailsEventsUseCase {
    override suspend fun execute(id: Int): DetailedEvent = eventsRepository.getDetailsEvent(id)
}

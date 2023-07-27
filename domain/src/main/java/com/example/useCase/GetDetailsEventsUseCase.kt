package com.example.useCase

import com.example.model.excursion.DetailedEvent

interface GetDetailsEventsUseCase {
    suspend fun execute(id: Int): DetailedEvent
}

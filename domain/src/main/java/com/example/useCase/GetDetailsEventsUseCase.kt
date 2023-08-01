package com.example.useCase

import com.example.model.DetailedEvent

interface GetDetailsEventsUseCase {
    suspend fun execute(id: Int): DetailedEvent
}

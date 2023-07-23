package com.example.useCase.impl

import com.example.model.Location
import com.example.repository.ExcursionRepository
import com.example.useCase.GetExcursionUseCase

internal class GetExcursionUseCaseImpl(
    private val eventsRepository: ExcursionRepository
) : GetExcursionUseCase {
    override suspend fun execute(location: Location) = eventsRepository.getExcursion(location)
}

package com.example.useCase.impl.excursion

import com.example.model.Location
import com.example.repository.ExcursionRepository
import com.example.useCase.excursion.GetExcursionUseCase

internal class GetExcursionUseCaseImpl(
    private val eventsRepository: ExcursionRepository
) : GetExcursionUseCase {
    override suspend fun execute(location: Location) = eventsRepository.getExcursion(location)
}

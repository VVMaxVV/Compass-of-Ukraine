package com.example.useCase.impl.excursion

import com.example.model.excursion.DetailedExcursion
import com.example.repository.ExcursionRepository
import com.example.useCase.excursion.GetDetailsExcursionUseCase

class GetDetailsExcursionUseCaseImpl(
    private val excursionDetailsRepository: ExcursionRepository
) : GetDetailsExcursionUseCase {
    override suspend fun execute(id: Int): DetailedExcursion =
        excursionDetailsRepository.getDetailsExcursion(id)
}

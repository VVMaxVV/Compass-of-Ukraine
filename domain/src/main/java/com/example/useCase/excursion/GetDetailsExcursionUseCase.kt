package com.example.useCase.excursion

import com.example.model.excursion.DetailedExcursion

interface GetDetailsExcursionUseCase {
    suspend fun execute(id: Int): DetailedExcursion
}

package com.example.useCase.excursion

import com.example.model.Excursion
import com.example.model.Location

interface GetExcursionUseCase {
    suspend fun execute(location: Location): List<Excursion>
}

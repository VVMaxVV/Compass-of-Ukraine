package com.example.repository

import com.example.mock.ExcursionFactory
import com.example.model.Excursion
import com.example.model.Location

internal class ExcursionRepositoryImpl(
    private val excursionFactory: ExcursionFactory
) : ExcursionRepository {
    override suspend fun getExcursion(location: Location): List<Excursion> = excursionFactory.get(location)
}

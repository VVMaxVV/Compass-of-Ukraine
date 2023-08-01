package com.example.repository

import com.example.mock.DetailsExcursionFactory
import com.example.mock.ExcursionFactory
import com.example.model.Excursion
import com.example.model.Location
import com.example.model.excursion.DetailedExcursion

internal class ExcursionRepositoryImpl(
    private val excursionFactory: ExcursionFactory,
    private val excursionDetailedFactory: DetailsExcursionFactory
) : ExcursionRepository {
    override suspend fun getExcursion(location: Location): List<Excursion> =
        excursionFactory.get(location)
    override suspend fun getDetailsExcursion(id: Int): DetailedExcursion = excursionDetailedFactory.get(id)
}

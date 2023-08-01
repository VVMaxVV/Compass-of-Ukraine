package com.example.repository

import com.example.model.Excursion
import com.example.model.Location
import com.example.model.excursion.DetailedExcursion

interface ExcursionRepository {
    suspend fun getExcursion(location: Location): List<Excursion>
    suspend fun getDetailsExcursion(id: Int): DetailedExcursion
}

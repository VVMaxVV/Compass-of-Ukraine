package com.example.repository

import com.example.model.Excursion
import com.example.model.Location

interface ExcursionRepository {
    suspend fun getExcursion(location: Location): List<Excursion>
}

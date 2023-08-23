package com.example.repository

import com.example.mock.AgeTagFactory
import com.example.model.AgeTag

class AgeTagRepositoryImpl(
    private val ageTagFactory: AgeTagFactory
) : AgeTagRepository {
    override suspend fun getAgeTags(): List<AgeTag> = ageTagFactory.get()
}

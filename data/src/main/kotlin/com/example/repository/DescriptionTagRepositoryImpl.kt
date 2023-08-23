package com.example.repository

import com.example.mock.DescriptionTagFactory
import com.example.model.DescriptionTag

internal class DescriptionTagRepositoryImpl(
    private val descriptionTagFactory: DescriptionTagFactory
) : DescriptionTagRepository {
    override suspend fun getDescriptionTags(): List<DescriptionTag> = descriptionTagFactory.get()
}

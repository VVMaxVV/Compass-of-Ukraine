package com.example.useCase.impl

import com.example.model.DescriptionTag
import com.example.repository.DescriptionTagRepository
import com.example.useCase.GetDescriptionTagsUseCase

internal class GetDescriptionTagsUseCaseImpl(
    private val descriptionTagRepository: DescriptionTagRepository
) : GetDescriptionTagsUseCase {
    override suspend fun execute(): List<DescriptionTag> =
        descriptionTagRepository.getDescriptionTags()
}

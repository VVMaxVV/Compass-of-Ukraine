package com.example.useCase.impl

import com.example.model.AgeTag
import com.example.repository.AgeTagRepository
import com.example.useCase.GetAgeTagsUseCase

class GetAgeTagsUseCaseImpl(
    private val ageTagRepository: AgeTagRepository
) : GetAgeTagsUseCase {

    override suspend fun execute(): List<AgeTag> = ageTagRepository.getAgeTags()
}

package com.example.useCase

import com.example.model.AgeTag

interface GetAgeTagsUseCase {
    suspend fun execute(): List<AgeTag>
}

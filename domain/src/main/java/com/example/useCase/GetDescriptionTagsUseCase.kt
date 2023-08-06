package com.example.useCase

import com.example.model.DescriptionTag

interface GetDescriptionTagsUseCase {
    suspend fun execute(): List<DescriptionTag>
}
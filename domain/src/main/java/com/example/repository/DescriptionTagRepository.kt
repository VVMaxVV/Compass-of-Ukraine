package com.example.repository

import com.example.model.DescriptionTag

interface DescriptionTagRepository {
    suspend fun getDescriptionTags(): List<DescriptionTag>
}

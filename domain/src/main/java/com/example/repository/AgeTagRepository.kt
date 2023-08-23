package com.example.repository

import com.example.model.AgeTag

interface AgeTagRepository {
    suspend fun getAgeTags(): List<AgeTag>
}

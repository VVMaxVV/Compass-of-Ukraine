package com.example.useCase

interface IsEventInFavoriteUseCase {
    suspend fun execute(id: Int): Boolean
}

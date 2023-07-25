package com.example.useCase

interface RemoveEventFromFavoriteUseCase {
    suspend fun execute(id: Int)
}

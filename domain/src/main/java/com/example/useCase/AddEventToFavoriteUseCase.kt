package com.example.useCase

interface AddEventToFavoriteUseCase {
    suspend fun execute(id: Int)
}

package com.example.useCase.excursion

interface RemoveExcursionFromFavouriteUseCase {
    suspend fun execute(id: Int)
}

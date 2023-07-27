package com.example.useCase.excursion

interface AddExcursionToFavouriteUseCase {
    suspend fun execute(id: Int)
}

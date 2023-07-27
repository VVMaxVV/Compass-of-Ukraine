package com.example.useCase.excursion

interface IsExcursionInFavoriteUseCase {
    suspend fun execute(id: Int): Boolean
}

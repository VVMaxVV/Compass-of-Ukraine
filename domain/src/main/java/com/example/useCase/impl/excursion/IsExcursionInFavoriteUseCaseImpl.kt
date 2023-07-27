package com.example.useCase.impl.excursion

import com.example.useCase.excursion.IsExcursionInFavoriteUseCase

class IsExcursionInFavoriteUseCaseImpl : IsExcursionInFavoriteUseCase {
    override suspend fun execute(id: Int): Boolean = false
}

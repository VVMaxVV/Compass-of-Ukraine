package com.example.useCase.impl

import com.example.useCase.IsEventInFavoriteUseCase

internal class IsEventInFavoriteUseCaseImpl : IsEventInFavoriteUseCase {
    override suspend fun execute(id: Int): Boolean = false
}

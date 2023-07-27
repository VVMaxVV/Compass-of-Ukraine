package com.example.di

import com.example.useCase.excursion.AddExcursionToFavouriteUseCase
import com.example.useCase.excursion.GetDetailsExcursionUseCase
import com.example.useCase.excursion.GetExcursionUseCase
import com.example.useCase.excursion.IsExcursionInFavoriteUseCase
import com.example.useCase.excursion.RemoveExcursionFromFavouriteUseCase
import com.example.useCase.impl.excursion.AddExcursionToFavouriteUseCaseImpl
import com.example.useCase.impl.excursion.GetDetailsExcursionUseCaseImpl
import com.example.useCase.impl.excursion.GetExcursionUseCaseImpl
import com.example.useCase.impl.excursion.IsExcursionInFavoriteUseCaseImpl
import com.example.useCase.impl.excursion.RemoveExcursionFromFavouriteUseCaseImpl
import org.koin.dsl.module

val excursionUseCaseModule = module {
    single<GetExcursionUseCase> { GetExcursionUseCaseImpl(get()) }
    single<GetDetailsExcursionUseCase> { GetDetailsExcursionUseCaseImpl(get()) }
    single<IsExcursionInFavoriteUseCase> { IsExcursionInFavoriteUseCaseImpl() }
    single<AddExcursionToFavouriteUseCase> { AddExcursionToFavouriteUseCaseImpl() }
    single<RemoveExcursionFromFavouriteUseCase> { RemoveExcursionFromFavouriteUseCaseImpl() }
}

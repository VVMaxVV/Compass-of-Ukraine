package com.example.di

import com.example.useCase.AddEventToFavoriteUseCase
import com.example.useCase.GetDetailsEventsUseCase
import com.example.useCase.GetEventsUseCase
import com.example.useCase.IsEventInFavoriteUseCase
import com.example.useCase.RemoveEventFromFavoriteUseCase
import com.example.useCase.impl.AddEventToFavoriteUseCaseImpl
import com.example.useCase.impl.GetDetailsEventsUseCaseImpl
import com.example.useCase.impl.GetEventsUseCaseImpl
import com.example.useCase.impl.IsEventInFavoriteUseCaseImpl
import com.example.useCase.impl.RemoveEventEventFromFavoriteUseCaseImpl
import org.koin.dsl.module

val eventsUseCaseModule = module {
    single<GetEventsUseCase> { GetEventsUseCaseImpl(get()) }
    single<GetDetailsEventsUseCase> { GetDetailsEventsUseCaseImpl(get()) }
    single<AddEventToFavoriteUseCase> { AddEventToFavoriteUseCaseImpl() }
    single<RemoveEventFromFavoriteUseCase> { RemoveEventEventFromFavoriteUseCaseImpl() }
    single<IsEventInFavoriteUseCase> { IsEventInFavoriteUseCaseImpl() }
}

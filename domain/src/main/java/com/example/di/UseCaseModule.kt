package com.example.di

import com.example.useCase.GetAgeTagsUseCase
import com.example.useCase.GetDescriptionTagsUseCase
import com.example.useCase.GetEventsUseCase
import com.example.useCase.impl.GetAgeTagsUseCaseImpl
import com.example.useCase.impl.GetDescriptionTagsUseCaseImpl
import com.example.useCase.impl.GetEventsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetEventsUseCase> { GetEventsUseCaseImpl(get()) }
    single<GetDescriptionTagsUseCase> { GetDescriptionTagsUseCaseImpl(get()) }
    single<GetAgeTagsUseCase> { GetAgeTagsUseCaseImpl(get()) }
}

package com.example.di

import com.example.useCase.GetExcursionUseCase
import com.example.useCase.impl.GetExcursionUseCaseImpl
import org.koin.dsl.module

val excursionUseCaseModule = module {
    single<GetExcursionUseCase> { GetExcursionUseCaseImpl(get()) }
}

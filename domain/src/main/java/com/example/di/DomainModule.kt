package com.example.di

import org.koin.dsl.module

val domainModule = module {
    includes(
        eventsUseCaseModule,
        excursionUseCaseModule
    )
}

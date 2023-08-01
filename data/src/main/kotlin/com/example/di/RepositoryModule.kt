package com.example.di

import com.example.repository.EventsRepository
import com.example.repository.ExcursionRepository
import com.example.repository.EventsRepositoryImpl
import com.example.repository.ExcursionRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<EventsRepository> { EventsRepositoryImpl(get(), get()) }
    single<ExcursionRepository> { ExcursionRepositoryImpl(get(), get()) }
}

package com.example.di

import com.example.repository.AgeTagRepository
import com.example.repository.AgeTagRepositoryImpl
import com.example.repository.DescriptionTagRepository
import com.example.repository.DescriptionTagRepositoryImpl
import com.example.repository.EventsRepository
import com.example.repository.EventsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<EventsRepository> { EventsRepositoryImpl(get()) }
    single<DescriptionTagRepository> { DescriptionTagRepositoryImpl(get()) }
    single<AgeTagRepository> { AgeTagRepositoryImpl(get()) }
}

package com.example.di

import com.example.mock.EventsFactory
import com.example.mock.ExcursionFactory
import org.koin.dsl.module

val mockModule = module {
    single { EventsFactory() }
    single { ExcursionFactory() }
}

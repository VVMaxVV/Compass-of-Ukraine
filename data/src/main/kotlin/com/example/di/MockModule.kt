package com.example.di

import com.example.mock.DetailsEventFactory
import com.example.mock.EventsFactory
import com.example.mock.ExcursionFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val mockModule = module {
    single { EventsFactory(androidContext()) }
    single { ExcursionFactory(androidContext()) }
    single { DetailsEventFactory(androidContext()) }
}

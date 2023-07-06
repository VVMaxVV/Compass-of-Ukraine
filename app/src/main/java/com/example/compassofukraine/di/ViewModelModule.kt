package com.example.compassofukraine.di

import com.example.compassofukraine.viewModel.EventsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EventsViewModel(get()) }
}

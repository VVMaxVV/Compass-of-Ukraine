package com.example.compassofukraine.di

import com.example.compassofukraine.viewModel.EventsViewModel
import com.example.compassofukraine.viewModel.ExcursionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EventsViewModel(get()) }
    viewModel { ExcursionViewModel(get()) }
}

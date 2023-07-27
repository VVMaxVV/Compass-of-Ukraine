package com.example.compassofukraine.di

import com.example.compassofukraine.viewModel.event.DetailedEventViewModel
import com.example.compassofukraine.viewModel.event.EventsViewModel
import com.example.compassofukraine.viewModel.excursion.ExcursionDetailViewModel
import com.example.compassofukraine.viewModel.excursion.ExcursionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EventsViewModel(get()) }
    viewModel { DetailedEventViewModel(get(), get(), get(), get()) }
    viewModel { ExcursionViewModel(get()) }
    viewModel { ExcursionDetailViewModel(get(), get(), get(), get()) }
}

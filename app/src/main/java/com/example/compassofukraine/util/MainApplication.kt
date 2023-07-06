package com.example.compassofukraine.util

import android.app.Application
import com.example.compassofukraine.di.viewModelModule
import com.example.di.dataModule
import com.example.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(dataModule, domainModule, viewModelModule)
        }
    }
}

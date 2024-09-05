package com.example.imran_mamirov_hw_7_6

import android.app.Application
import com.example.data.module.dataModule
import com.example.imran_mamirov_hw_7_6.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, appModule)
        }
    }
}
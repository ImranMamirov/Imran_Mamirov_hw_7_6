package com.example.imran_mamirov_hw_7_6.di

import org.koin.dsl.module

val appModule = module {
    includes(viewModelModule)
}
package com.example.imran_mamirov_hw_7_6.di

import com.example.imran_mamirov_hw_7_6.ui.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
   includes(databaseModule, repositoryModule, usesCaseModule, viewModelModule)
}
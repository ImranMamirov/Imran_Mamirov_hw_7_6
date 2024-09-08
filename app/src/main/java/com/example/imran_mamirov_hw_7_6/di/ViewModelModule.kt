package com.example.imran_mamirov_hw_7_6.di

import com.example.imran_mamirov_hw_7_6.ui.fragment.taskCreate.TaskCreateViewModel
import com.example.imran_mamirov_hw_7_6.ui.fragment.taskList.TaskListVIewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TaskCreateViewModel(get())
    }

    viewModel {
        TaskListVIewModel(get(), get(), get())
    }
}
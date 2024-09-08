package com.example.imran_mamirov_hw_7_6.di

import com.example.domain.usescase.TasksUseCase
import org.koin.dsl.module

val usesCaseModule = module {
    factory { TasksUseCase.InsertTaskUseCase(get()) }
    factory { TasksUseCase.GetAllTasksUseCase(get()) }
    factory { TasksUseCase.GetTaskByIdUseCase(get()) }
    factory { TasksUseCase.UpdateTaskUseCase(get()) }
    factory { TasksUseCase.DeleteTaskUseCase(get()) }
}
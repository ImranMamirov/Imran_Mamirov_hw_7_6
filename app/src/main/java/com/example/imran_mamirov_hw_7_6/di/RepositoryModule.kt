package com.example.imran_mamirov_hw_7_6.di

import com.example.data.repository.TaskRepositoryImpl
import com.example.domain.interfaces.TaskRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<TaskRepository> { TaskRepositoryImpl(get()) }
}
package com.example.data.di

import com.example.data.repository.TaskRepositoryImpl
import com.example.domain.interfaces.TaskRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<TaskRepository> { TaskRepositoryImpl(get()) }
}
package com.example.data.di

import androidx.room.Room
import com.example.data.db.TaskDatabase
import com.example.data.repository.TaskRepositoryImpl
import com.example.domain.interfaces.TaskRepository
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(get(), TaskDatabase::class.java, "task_db")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<TaskDatabase>().taskDao() }
    single<TaskRepository> { TaskRepositoryImpl(get()) }
}
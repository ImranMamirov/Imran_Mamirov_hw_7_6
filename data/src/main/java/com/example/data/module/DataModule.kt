package com.example.data.module

import androidx.room.Room
import com.example.data.db.AppDataBase
import com.example.data.repository.TaskRepositoryImpl
import com.example.domain.repository.TaskRepository
import org.koin.dsl.module

val dataModule = module {
    single { Room.databaseBuilder(get(), AppDataBase::class.java, "database-name").build() }
    single { get<AppDataBase>().taskDao() }
    single<TaskRepository> { TaskRepositoryImpl(get()) }
}
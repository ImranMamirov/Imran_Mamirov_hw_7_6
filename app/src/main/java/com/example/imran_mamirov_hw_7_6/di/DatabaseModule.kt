package com.example.imran_mamirov_hw_7_6.di

import androidx.room.Room
import com.example.data.db.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "task")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().taskDao()
    }
}
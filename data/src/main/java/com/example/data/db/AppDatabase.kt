package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.TaskDao
import com.example.domain.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
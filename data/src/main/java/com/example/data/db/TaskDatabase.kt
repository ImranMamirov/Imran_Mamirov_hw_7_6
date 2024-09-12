package com.example.data.db

import com.example.data.model.TaskEntityDto
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.TaskDao

@Database(entities = [TaskEntityDto::class], version = 2)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.TaskModel

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<TaskModel>

    @Insert
    suspend fun insertTask(task: TaskModel)

    @Query("DELETE FROM tasks WHERE taskId = :id")
    suspend fun deleteTask(id: Int)
}
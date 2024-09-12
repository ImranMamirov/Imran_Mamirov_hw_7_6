package com.example.data.dao

import com.example.data.model.TaskEntityDto
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntityDto)

    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
    suspend fun getTaskById(taskId: Int): TaskEntityDto?

    @Query("DELETE FROM task_table WHERE taskId = :taskId")
    suspend fun deleteTask(taskId: Long)

    @Query("SELECT * FROM task_table")
    fun fetchTasks(): Flow<List<TaskEntityDto>>
}
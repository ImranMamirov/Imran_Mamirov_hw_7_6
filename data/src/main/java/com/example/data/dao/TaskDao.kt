package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.TaskEntityDto
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: TaskEntityDto)

    @Query("SELECT * FROM task")
    fun getAllTasks(): Flow<List<TaskEntityDto>>

    @Query("SELECT * FROM task WHERE taskId = :taskId")
    fun getTaskById(taskId: Int): Flow<TaskEntityDto?>

    @Update
    suspend fun update(task: TaskEntityDto)

    @Query("DELETE FROM task WHERE taskId = :taskId")
    suspend fun delete(taskId: Int)

    @Query("SELECT * FROM task")
    suspend fun fetchTasks(): List<TaskEntityDto>
}
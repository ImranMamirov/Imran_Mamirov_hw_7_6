package com.example.domain.interfaces

import com.example.domain.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<TaskModel>>
    suspend fun insertTask(task: TaskModel)
    suspend fun deleteTask(task: TaskModel)
    suspend fun updateTask(task: TaskModel)
    fun getTaskById(taskId: Long): Flow<TaskModel?>
}
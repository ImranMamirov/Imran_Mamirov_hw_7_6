package com.example.domain.interfaces

import com.example.domain.model.Task
import com.example.domain.model.TaskEntityModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: TaskEntityModel)
    suspend fun deleteTask(task: Int)
    suspend fun updateTask(task: Task)
    fun getTaskById(taskId: Int): Flow<Task?>
    suspend fun fetchTasks(): List<TaskEntityModel>
}
package com.example.domain.interfaces

import com.example.domain.model.Task
import com.example.domain.model.TaskEntityModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTask(taskEntityModel: TaskEntityModel)
    suspend fun getTaskById(taskId: Int): TaskEntityModel?
    suspend fun deleteTask(taskId: Int)
    suspend fun fetchTask() : Flow<List<TaskEntityModel>>
}
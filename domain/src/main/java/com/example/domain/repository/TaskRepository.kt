package com.example.domain.repository

import com.example.domain.model.Task

interface TaskRepository {
    suspend fun getAllTasks(): List<Task>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(id: Int)
}
package com.example.domain.repository

import com.example.domain.model.Task

interface TaskRepository {
    suspend fun insert(task: Task)
    fun getAllTasks(): List<Task>
    suspend fun getTaskById(taskId: Long): Task?
    suspend fun update(task: Task)
    suspend fun delete(task: Task)
}
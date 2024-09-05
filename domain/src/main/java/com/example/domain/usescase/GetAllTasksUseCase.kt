package com.example.domain.usescase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class GetAllTasksUseCase(private val taskRepository: TaskRepository) {
    suspend fun execute(): List<Task> = taskRepository.getAllTasks()
}
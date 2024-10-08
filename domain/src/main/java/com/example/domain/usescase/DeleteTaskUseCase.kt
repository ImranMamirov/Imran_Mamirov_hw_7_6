package com.example.domain.usescase

import com.example.domain.interfaces.TaskRepository

class DeleteTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskId: Long) {
        taskRepository.deleteTask(taskId)
    }
}
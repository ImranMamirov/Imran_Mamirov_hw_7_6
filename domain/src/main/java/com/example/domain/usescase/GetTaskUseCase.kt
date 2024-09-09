package com.example.domain.usescase

import com.example.domain.interfaces.TaskRepository
import com.example.domain.model.TaskEntityModel

class GetTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskId: Int): TaskEntityModel? {
        return taskRepository.getTaskById(taskId)
    }
}
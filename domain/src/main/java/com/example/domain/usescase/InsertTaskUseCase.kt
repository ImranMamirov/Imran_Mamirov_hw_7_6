package com.example.domain.usescase

import com.example.domain.interfaces.TaskRepository
import com.example.domain.model.TaskEntityModel

class InsertTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: TaskEntityModel) {
        taskRepository.insertTask(task)
    }
}
package com.example.domain.usescase

import com.example.domain.interfaces.TaskRepository


class FetchTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke() = taskRepository.fetchTask()
}
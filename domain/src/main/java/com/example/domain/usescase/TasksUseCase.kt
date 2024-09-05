package com.example.domain.usescase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class TasksUseCase(private val taskRepository: TaskRepository) {
    class InsertTaskUseCase(private val repository: TaskRepository) {
        suspend fun execute(task: Task) = repository.insert(task)
    }

    class GetAllTasksUseCase(private val repository: TaskRepository) {
        fun execute() = repository.getAllTasks()
    }

    class GetTaskByIdUseCase(private val repository: TaskRepository) {
        suspend fun execute(taskId: Long) = repository.getTaskById(taskId)
    }

    class UpdateTaskUseCase(private val repository: TaskRepository) {
        suspend fun execute(task: Task) = repository.update(task)
    }

    class DeleteTaskUseCase(private val repository: TaskRepository) {
        suspend fun execute(task: Task) = repository.delete(task)
    }
}
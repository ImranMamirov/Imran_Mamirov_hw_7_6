package com.example.domain.usescase

import com.example.domain.interfaces.TaskRepository
import com.example.domain.model.TaskModel

class TasksUseCase(private val taskRepository: TaskRepository) {
    class InsertTaskUseCase(private val repository: TaskRepository) {
        suspend fun execute(task: TaskModel) = repository.insertTask(task)
    }

    class GetAllTasksUseCase(private val repository: TaskRepository) {
        fun execute() = repository.getAllTasks()
    }

    class GetTaskByIdUseCase(private val repository: TaskRepository) {
        suspend fun execute(taskId: Long) = repository.getTaskById(taskId)
    }

    class UpdateTaskUseCase(private val repository: TaskRepository) {
        suspend fun execute(task: TaskModel) = repository.updateTask(task)
    }

    class DeleteTaskUseCase(private val repository: TaskRepository) {
        suspend fun execute(task: TaskModel) = repository.deleteTask(task)
    }
}
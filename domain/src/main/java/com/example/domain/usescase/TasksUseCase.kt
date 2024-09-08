package com.example.domain.usescase

import com.example.domain.interfaces.TaskRepository
import com.example.domain.model.Task
import com.example.domain.model.TaskEntityModel

class TasksUseCase(private val taskRepository: TaskRepository) {
    class InsertTaskUseCase(private val repository: TaskRepository) {
        suspend operator fun invoke(task: TaskEntityModel) = repository.insertTask(task)
    }

    class GetAllTasksUseCase(private val repository: TaskRepository) {
        suspend operator fun invoke() = repository.getAllTasks()
    }

    class GetTaskByIdUseCase(private val repository: TaskRepository) {
        suspend operator fun invoke(taskId: Int) = repository.getTaskById(taskId)
    }

    class UpdateTaskUseCase(private val repository: TaskRepository) {
        suspend operator fun invoke(task: Task) = repository.updateTask(task)
    }

    class DeleteTaskUseCase(private val repository: TaskRepository) {
        suspend operator fun invoke(task: Int) = repository.deleteTask(task)
    }

    class FetchTaskUseCase(private val repository: TaskRepository) {
        suspend operator fun invoke() = repository.fetchTasks()
    }
}
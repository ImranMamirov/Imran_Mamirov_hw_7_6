package com.example.data.repository

import com.example.data.dao.TaskDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {
    override suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks().map { it.toDomain() }
    }

    override suspend fun insertTask(task: Task) {
        return taskDao.insertTask(task.toEntity())
    }

    override suspend fun deleteTask(id: Int) {
        taskDao.deleteTask(id)
    }
}
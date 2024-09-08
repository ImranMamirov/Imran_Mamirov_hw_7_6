package com.example.data.repository

import com.example.data.dao.TaskDao
import com.example.data.model.TaskEntityDto
import com.example.data.model.toDomain
import com.example.domain.interfaces.TaskRepository
import com.example.domain.model.Task
import com.example.domain.model.TaskEntityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { tasks ->
            tasks.map { Task(it.taskId, it.taskName) }
        }
    }

    override suspend fun insertTask(task: TaskEntityModel) {
        taskDao.insert(TaskEntityDto(task.taskId, task.taskName))
    }

    override suspend fun deleteTask(task: Int) {
        taskDao.delete(task)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.update(TaskEntityDto(task.taskId, task.taskName))
    }

    override fun getTaskById(taskId: Int): Flow<Task?> {
        return taskDao.getTaskById(taskId).map { taskEntity ->
            taskEntity?.let { Task(it.taskId, it.taskName) }
        }
    }

    override suspend fun fetchTasks(): List<TaskEntityModel> {
        return taskDao.fetchTasks().map { it.toDomain() }
    }
}
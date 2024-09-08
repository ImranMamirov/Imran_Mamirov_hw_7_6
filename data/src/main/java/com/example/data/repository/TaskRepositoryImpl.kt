package com.example.data.repository

import com.example.data.dao.TaskDao
import com.example.data.model.TaskEntity
import com.example.domain.interfaces.TaskRepository
import com.example.domain.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    override fun getAllTasks(): Flow<List<TaskModel>> {
        return taskDao.getAllTasks().map { tasks ->
            tasks.map { TaskModel(it.taskId, it.taskName) }
        }
    }

    override suspend fun insertTask(task: TaskModel) {
        taskDao.insert(TaskEntity(task.taskId, task.taskName))
    }

    override suspend fun deleteTask(task: TaskModel) {
        taskDao.delete(TaskEntity(task.taskId, task.taskName))
    }

    override suspend fun updateTask(task: TaskModel) {
        taskDao.update(TaskEntity(task.taskId, task.taskName))
    }

    override fun getTaskById(taskId: Long): Flow<TaskModel?> {
        return taskDao.getTaskById(taskId).map { taskEntity ->
            taskEntity?.let { TaskModel(it.taskId, it.taskName) }
        }
    }
}
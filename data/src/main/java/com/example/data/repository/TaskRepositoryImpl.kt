package com.example.data.repository

import com.example.data.dao.TaskDao
import com.example.domain.interfaces.TaskRepository
import com.example.domain.model.TaskEntityModel
import com.example.data.model.fromDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.data.model.toDomain

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {
    override suspend fun insertTask(taskEntityModel: TaskEntityModel): Long {
        return taskDao.insertTask(taskEntityModel.fromDomain())
    }

    override suspend fun getTaskById(taskId: Int): TaskEntityModel? {
        return taskDao.getTaskById(taskId)?.toDomain()
    }

    override suspend fun deleteTask(taskId: Long) {
        taskDao.deleteTask(taskId)
    }

    override suspend fun fetchTask(): Flow<List<TaskEntityModel>> {
        return taskDao.fetchTasks().map { taskList ->
            taskList.map { it.toDomain() }
        }
    }
}
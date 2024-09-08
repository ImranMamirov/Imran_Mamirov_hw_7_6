package com.example.imran_mamirov_hw_7_6.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.TaskModel
import com.example.domain.usescase.TasksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(
    private val insertTaskUseCase: TasksUseCase.InsertTaskUseCase,
    private val getAllTasksUseCase: TasksUseCase.GetAllTasksUseCase,
    private val getTaskByIdUseCase: TasksUseCase.GetTaskByIdUseCase,
    private val updateTaskUseCase: TasksUseCase.UpdateTaskUseCase,
    private val deleteTaskUseCase: TasksUseCase.DeleteTaskUseCase
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<TaskModel>>(emptyList())
    val tasks: StateFlow<List<TaskModel>> get() = _tasks

    init {
        fetchAllTasks()
    }

    private fun fetchAllTasks() {
        viewModelScope.launch {
            getAllTasksUseCase.execute().collect { taskList ->
                _tasks.value = taskList
            }
        }
    }

    fun addTask(task: TaskModel) {
        viewModelScope.launch {
            insertTaskUseCase.execute(task)
            fetchAllTasks()
        }
    }

    fun updateTask(task: TaskModel) {
        viewModelScope.launch {
            updateTaskUseCase.execute(task)
            fetchAllTasks()
        }
    }

    fun deleteTask(task: TaskModel) {
        viewModelScope.launch {
            deleteTaskUseCase.execute(task)
            fetchAllTasks()
        }
    }

    fun getTaskById(taskId: Long) {
        viewModelScope.launch {
            getTaskByIdUseCase.execute(taskId).collect { task ->
            }
        }
    }
}
package com.example.imran_mamirov_hw_7_6.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Task
import com.example.domain.usescase.TasksUseCase
import kotlinx.coroutines.launch

class TaskViewModel(
    private val insertTaskUseCase: TasksUseCase.InsertTaskUseCase,
    private val getAllTasksUseCase: TasksUseCase.GetAllTasksUseCase,
    private val getTaskByIdUseCase: TasksUseCase.GetTaskByIdUseCase,
    private val updateTaskUseCase: TasksUseCase.UpdateTaskUseCase,
    private val deleteTaskUseCase: TasksUseCase.DeleteTaskUseCase
) : ViewModel() {
    val tasks: List<Task> = getAllTasksUseCase.execute()

    fun addTask(task: Task) {
        viewModelScope.launch {
            insertTaskUseCase.execute(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTaskUseCase.execute(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase.execute(task)
        }
    }
}
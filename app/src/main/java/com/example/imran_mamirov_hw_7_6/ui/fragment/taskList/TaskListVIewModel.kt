package com.example.imran_mamirov_hw_7_6.ui.fragment.taskList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usescase.TasksUseCase
import kotlinx.coroutines.launch

class TaskListVIewModel(
    private val getTaskByIdUseCase: TasksUseCase.GetTaskByIdUseCase,
    private val deleteUseCase: TasksUseCase.DeleteTaskUseCase,
    private val fetchUseCase: TasksUseCase.FetchTaskUseCase
) : ViewModel() {

    fun getTaskById(taskId: Int) {
        viewModelScope.launch {
            getTaskByIdUseCase(taskId)
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            deleteUseCase(taskId)
        }
    }

    fun fetchTasks() {
        viewModelScope.launch {
            fetchUseCase()
        }
    }
}
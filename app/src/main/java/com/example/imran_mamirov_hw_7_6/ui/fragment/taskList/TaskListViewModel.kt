package com.example.imran_mamirov_hw_7_6.ui.fragment.taskList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Task
import com.example.domain.usescase.DeleteTaskUseCase
import com.example.domain.usescase.FetchTaskUseCase
import com.example.domain.usescase.GetTaskUseCase
import kotlinx.coroutines.launch

class TaskListViewModel(
    private val getTaskUseCase: GetTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val fetchTaskUseCase: FetchTaskUseCase
) : ViewModel() {
    fun getTaskById(taskId: Int) {
        viewModelScope.launch {
            getTaskUseCase(taskId)
        }
    }

    fun deleteTask(taskId: Long) {
        viewModelScope.launch {
            deleteTaskUseCase(taskId)
        }
    }

    suspend fun fetchTasks() = fetchTaskUseCase()
}
package com.example.imran_mamirov_hw_7_6.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.data.model.TaskModel
import com.example.domain.model.Task
import com.example.domain.usescase.GetAllTasksUseCase

class TaskViewModel(private val getAllTasksUseCase: GetAllTasksUseCase) : ViewModel() {
    val tasks: LiveData<List<Task>> = liveData {
        emit(getAllTasksUseCase.execute())
    }
}
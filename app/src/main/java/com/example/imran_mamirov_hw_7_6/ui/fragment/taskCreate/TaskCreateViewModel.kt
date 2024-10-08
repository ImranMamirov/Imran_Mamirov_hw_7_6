package com.example.imran_mamirov_hw_7_6.ui.fragment.taskCreate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.PrimaryKey
import com.example.data.model.TaskEntityDto
import com.example.domain.interfaces.TaskRepository
import com.example.domain.usescase.DeleteTaskUseCase
import com.example.domain.usescase.GetTaskUseCase
import com.example.domain.usescase.InsertTaskUseCase
import com.example.imran_mamirov_hw_7_6.models.TaskEntityUI
import com.example.imran_mamirov_hw_7_6.models.fromDomain
import kotlinx.coroutines.launch

class TaskCreateViewModel(
    private val insertTaskUseCase: InsertTaskUseCase
) : ViewModel() {

    fun insertTask(task: TaskEntityUI) {
        viewModelScope.launch {
            val taskEntityModel =
                task.fromDomain()
            insertTaskUseCase(taskEntityModel)
        }
    }
}

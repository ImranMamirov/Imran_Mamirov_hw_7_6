package com.example.imran_mamirov_hw_7_6.models

import com.example.domain.model.TaskEntityModel

data class TaskEntityUI(
    val taskId: Int,
    val taskName: String
)

fun TaskEntityModel.toUI() = TaskEntityUI(taskId!!, taskName)

fun TaskEntityUI.fromDomain() = TaskEntityModel(taskId, taskName)
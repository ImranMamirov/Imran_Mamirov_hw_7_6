package com.example.data.mapper

import com.example.data.model.TaskModel
import com.example.domain.model.Task

fun TaskModel.toDomain(): Task = Task(
    taskId = this.taskId,
    taskName = this.taskName
)

fun Task.toEntity(): TaskModel = TaskModel(
    taskId = this.taskId,
    taskName = this.taskName
)
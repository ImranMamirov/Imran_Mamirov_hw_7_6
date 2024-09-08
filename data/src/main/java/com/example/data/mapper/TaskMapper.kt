package com.example.data.mapper

import com.example.data.model.TaskEntity
import com.example.domain.model.TaskModel

fun TaskModel.toEntity(): TaskEntity = TaskEntity(
    taskId = this.taskId,
    taskName = this.taskName
)

fun TaskEntity.toDomain(): TaskModel = TaskModel(
    taskId = this.taskId,
    taskName = this.taskName
)
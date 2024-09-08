package com.example.data.mapper

import com.example.data.model.TaskEntityDto
import com.example.domain.model.Task

fun Task.toEntity(): TaskEntityDto = TaskEntityDto(
    taskId = this.taskId!!,
    taskName = this.taskName
)

fun TaskEntityDto.toDomain(): Task = Task(
    taskId = this.taskId,
    taskName = this.taskName
)
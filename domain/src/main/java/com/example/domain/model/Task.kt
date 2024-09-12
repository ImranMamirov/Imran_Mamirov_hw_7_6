package com.example.domain.model

data class Task(
    val taskId: Long = 0,
    val taskName: String,
    val description: String,
    val time: Long
)

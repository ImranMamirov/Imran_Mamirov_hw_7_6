package com.example.imran_mamirov_hw_7_6.ui.fragment.taskList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.imran_mamirov_hw_7_6.databinding.ItemTaskBinding
import com.example.imran_mamirov_hw_7_6.models.TaskEntityUI

class TaskListAdapter : ListAdapter<TaskEntityUI, TaskListAdapter.TaskListViewHolder>(TaskDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        return TaskListViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class TaskListViewHolder(private val binding: ItemTaskBinding) :
        ViewHolder(binding.root) {
        fun onBind(taskEntityUi: TaskEntityUI) {

        }
    }

    companion object {
        class TaskDiffUtil : DiffUtil.ItemCallback<TaskEntityUI>() {
            override fun areItemsTheSame(oldItem: TaskEntityUI, newItem: TaskEntityUI): Boolean {
                return oldItem.taskId == newItem.taskId
            }

            override fun areContentsTheSame(oldItem: TaskEntityUI, newItem: TaskEntityUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}
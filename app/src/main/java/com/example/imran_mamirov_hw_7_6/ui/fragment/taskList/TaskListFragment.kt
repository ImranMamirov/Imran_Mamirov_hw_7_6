package com.example.imran_mamirov_hw_7_6.ui.fragment.taskList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imran_mamirov_hw_7_6.models.toUi
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.map
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.imran_mamirov_hw_7_6.databinding.FragmentTaskListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskListFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskListBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<TaskListViewModel>()

    private val taskListAdapter = TaskListAdapter(onItemClick = ::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTasksList.adapter = taskListAdapter
        setupClickListener()
        iniFetchTask()
        setupRecyclerView()
    }

    private fun iniFetchTask() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchTasks().collectLatest {
                taskListAdapter.submitList(it.map { it.toUi() })
            }
        }
    }

    private fun setupClickListener() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(
                TaskListFragmentDirections.actionTaskListFragmentToTaskCreateFragment(
                    id
                )
            )
        }
    }

    private fun setupRecyclerView() {
        binding.rvTasksList.adapter = taskListAdapter

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val task = taskListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteTask(task.taskId)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.rvTasksList)
    }

    private fun onItemClick(taskId: Int) {
        findNavController().navigate(
            TaskListFragmentDirections.actionTaskListFragmentToTaskDetailFragment(
                taskId
            )
        )
    }
}
package com.example.imran_mamirov_hw_7_6.ui.fragment.taskList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.imran_mamirov_hw_7_6.databinding.FragmentTaskListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskListFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskListBinding.inflate(layoutInflater)
    }

    private val listViewModel by viewModel<TaskListVIewModel>()

    private val listAdapter = TaskListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTasksList.adapter = listAdapter
        setupClickListener()
        initFetchTasks()
    }

    private fun initFetchTasks() {
        viewLifecycleOwner.lifecycleScope.launch {
            listAdapter.submitList(listViewModel.fetchTasks().map { it.toUI()})
        }
    }

    private fun setupClickListener() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(TaskListFragmentDirections.actionTaskListFragmentToTaskCreateFragment(id))
        }
    }
}
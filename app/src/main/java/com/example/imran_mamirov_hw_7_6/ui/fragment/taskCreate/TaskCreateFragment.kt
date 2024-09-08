package com.example.imran_mamirov_hw_7_6.ui.fragment.taskCreate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imran_mamirov_hw_7_6.databinding.FragmentTaskCreateBinding
import com.example.imran_mamirov_hw_7_6.models.TaskEntityUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskCreateFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskCreateBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<TaskCreateViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBtnCreateListener()
    }

    private fun setupBtnCreateListener() {
        binding.btnCreate.setOnClickListener {
            val taskName = binding.etDescription.text.toString()
            viewModel.insertTask(
                TaskEntityUI(
                    taskId = 1,
                    taskName = taskName
                )
            )
        }
    }
}
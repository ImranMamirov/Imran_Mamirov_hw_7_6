package com.example.imran_mamirov_hw_7_6.ui.fragment.detail

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imran_mamirov_hw_7_6.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<TaskDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taskId = arguments?.getInt("taskId") ?: return
        viewModel.getTaskById(taskId).observe(viewLifecycleOwner) { task ->
            task?.let {
                binding.tvTaskName.text = it.taskName
                binding.tvTaskDescription.text = it.description
                binding.tvTaskTime.text = formatTime(it.time)
            }
        }
    }

    private fun formatTime(timeInMillis: Long): String {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = timeInMillis
        }
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return String.format("%02d:%02d", hour, minute)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
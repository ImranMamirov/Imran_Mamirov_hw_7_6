package com.example.imran_mamirov_hw_7_6.ui.fragment.taskCreate

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtnCreateListener()
        showTimePickerDialog()
    }

    private fun setupBtnCreateListener() {
        binding.btnCreate.setOnClickListener {
            val taskName = binding.etDescription.text.toString()
            val description = binding.etDescription.text.toString()
            val time = binding.btnTime
            viewModel.insertTask(
                TaskEntityUI(
                    1,
                    taskName = taskName,
                    description = description,
                    time = time
                )
            )
            findNavController().popBackStack()
        }
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->
                val selectedTimeInMillis = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, selectedHour)
                    set(Calendar.MINUTE, selectedMinute)
                }.timeInMillis
                // Обновите UI или переменную с выбранным временем
            },
            hour,
            minute,
            true
        ).show()
    }
}
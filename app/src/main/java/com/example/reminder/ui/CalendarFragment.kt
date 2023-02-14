package com.example.reminder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.reminder.R
import com.example.reminder.databinding.FragmentCalendarBinding
import java.text.DateFormat
import java.util.*

class CalendarFragment: Fragment(R.layout.fragment_calendar) {
    private var date = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCalendarBinding =
           FragmentCalendarBinding.inflate(inflater, container, false)

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            binding.dateTvCF.text = "$dayOfMonth.${month + 1}.$year"
            date = binding.dateTvCF.text.toString()
        }

        binding.saveButton.setOnClickListener {
            val selectedDate = binding.calendarView.date
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selectedDate
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
            binding.dateTvCF.text = "Selected date: ${dateFormatter.format(calendar.time)}"
            val bundle = Bundle()
            bundle.putString("date", date)
            findNavController().navigateUp()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }



        return binding.root
    }
}
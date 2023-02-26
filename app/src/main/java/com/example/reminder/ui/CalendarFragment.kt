package com.example.reminder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.reminder.R
import com.example.reminder.databinding.FragmentCalendarBinding
import com.example.reminder.databinding.FragmentCreateNewUserBinding
import java.text.DateFormat
import java.util.*

class CalendarFragment : Fragment(R.layout.fragment_calendar) {
    private lateinit var binding: FragmentCalendarBinding
    private var date = ""


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding: FragmentCalendarBinding =
//            FragmentCalendarBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalendarBinding.bind(view)

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            binding.dateTvCF.text = "$dayOfMonth.${month + 1}.$year"
        }

        binding.saveButton.setOnClickListener {
            val selectedDate = binding.calendarView.date
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selectedDate
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
            binding.dateTvCF.text = "${dateFormatter.format(calendar.time)}"
            date = binding.dateTvCF.text.toString()
            val bundle = Bundle()
            bundle.putString("date", date)
            findNavController().navigate(R.id.createNewUser, bundle)
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        //return binding.root
    }
}
package com.example.reminder.utils

import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun fullUserNameGenerator(lastName: String, firstName: String, middleName: String): String {
        return "$lastName $firstName $middleName"
    }

    fun updateDateLabel(calendar: Calendar, editText: EditText) {
        val format = "dd.MM.yyyy"
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        editText.setText(simpleDateFormat.format(calendar.time))
    }
}
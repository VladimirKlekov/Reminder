package com.example.reminder.utils

object Utils {

    fun fullUserNameGenerator(lastName: String, firstName: String, middleName: String): String {
        return "$lastName $firstName $middleName"
    }
}
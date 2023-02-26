package com.example.reminder.dto

data class User (
    val id: Int?,
    val lastName: String,
//    val firstName: String,
//    val middleName: String,
    val dateBirth: String?,
    val event: Status
        ) {

    enum class Status {
        BIRTHDAY, EVENT
    }
}

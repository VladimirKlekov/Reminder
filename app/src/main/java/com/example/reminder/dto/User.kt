package com.example.reminder.dto

data class User (
    val id: Int,
    val lastName: String,
    val firstName: String,
    val middleName: String,
    val dateBirth: Long,
    val event: String
        )

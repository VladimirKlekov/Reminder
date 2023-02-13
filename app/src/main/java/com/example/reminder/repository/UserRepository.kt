package com.example.reminder.repository

import com.example.reminder.dto.User

interface UserRepository {
    val userList: ArrayList<User>
    fun createUser(user: User)
}
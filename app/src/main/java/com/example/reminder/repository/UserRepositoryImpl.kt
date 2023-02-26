package com.example.reminder.repository

import com.example.reminder.dto.User

class UserRepositoryImpl():UserRepository {

    override var userList: List<User> = emptyList()
    private set


    override fun createUser(user: User) {
        userList.plus(user)
    }
}
package com.example.reminder.repository

import com.example.reminder.dto.User

class UserRepositoryImpl():UserRepository {

    override var userList: ArrayList<User> = ArrayList()
    private set


    override fun createUser(user: User) {
        userList.add(user)
    }
}
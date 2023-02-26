package com.example.reminder.veiwmodel

import androidx.lifecycle.ViewModel
import com.example.reminder.dto.User
import com.example.reminder.repository.UserRepository
import com.example.reminder.repository.UserRepositoryImpl

class UserViewModel(
) : ViewModel() {



    private val userRepository: UserRepository = UserRepositoryImpl()


    val data: List<User>
        get() = userRepository.userList

    fun createUser(user: User) {
        userRepository.createUser(user)
    }

    fun editUser(user: User) {

    }

    val statuses =
        listOf(
            User.Status.BIRTHDAY,
            User.Status.EVENT,
        )
}
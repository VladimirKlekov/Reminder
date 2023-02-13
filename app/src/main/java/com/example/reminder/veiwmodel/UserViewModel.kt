package com.example.reminder.veiwmodel

import androidx.lifecycle.ViewModel
import com.example.reminder.dto.User
import com.example.reminder.repository.UserRepository

class UserViewModel  (private val userRepository: UserRepository) : ViewModel() {


    fun createUser(user: User) {
        userRepository.createUser(user)
    }

    fun editUser(user: User) {

    }
}
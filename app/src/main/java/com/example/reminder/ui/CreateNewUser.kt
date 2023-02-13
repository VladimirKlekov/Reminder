package com.example.reminder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.reminder.R
import com.example.reminder.databinding.FragmentCreateNewUserBinding
import com.example.reminder.databinding.FragmentMainBinding

class CreateNewUser: Fragment(R.layout.fragment_create_new_user){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCreateNewUserBinding = FragmentCreateNewUserBinding.inflate(inflater, container, false)


        binding.saveButton.setOnClickListener {
            findNavController().navigateUp()
        }



        return binding.root
    }

}
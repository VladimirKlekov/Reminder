package com.example.reminder.ui




import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.reminder.R
import com.example.reminder.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)


        binding.addEventBtnMA.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_createNewUser)
        }


        return binding.root
    }

}
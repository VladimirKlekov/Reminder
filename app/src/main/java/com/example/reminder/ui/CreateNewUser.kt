package com.example.reminder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.reminder.R
import com.example.reminder.databinding.FragmentCreateNewUserBinding
import com.example.reminder.databinding.FragmentMainBinding
import com.example.reminder.dto.User
import com.example.reminder.utils.Utils
import com.example.reminder.veiwmodel.UserViewModel

class CreateNewUser : Fragment(R.layout.fragment_create_new_user) {

    private lateinit var binding: FragmentCreateNewUserBinding
    private  val viewModel: UserViewModel by viewModels()

//
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
    return super.onCreate(savedInstanceState)
}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCreateNewUserBinding = FragmentCreateNewUserBinding.inflate(inflater, container, false)


        binding.saveButton.setOnClickListener {
            val createPatient = User(
                id = null,

                    lastName = Utils.fullUserNameGenerator(binding.lastNameTextInputEditText.text.toString(),
                        binding.firstNameTextInputEditText.text.toString(),
                        binding.middleNameTextInputEditText.text.toString()),
//                    firstName = binding.firstNameTextInputEditText.text.toString(),
//                    middleName = binding.middleNameTextInputEditText.text.toString(),
                dateBirth = 0L,
                event = "День рождения"
            )
            viewModel.createUser(createPatient)
            findNavController().navigateUp()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }


    private fun showErrorToast(text: Int) {
        Toast.makeText(
            requireContext(),
            text,
            Toast.LENGTH_LONG
        ).show()
    }

//    private fun updateLabel(calendar: Calendar) {
//        val formatData = "dd.MM.YYYY"
//        val sdf = SimpleDateFormat(formatData, Locale.UK)
//        tvDataPicker.setText(sdf.format(calendar.time))
//        dataString = sdf.format(calendar.time)
//    }

}
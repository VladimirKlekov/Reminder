package com.example.reminder.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import java.text.SimpleDateFormat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.reminder.R
import com.example.reminder.databinding.FragmentCreateNewUserBinding
import com.example.reminder.databinding.FragmentMainBinding
import com.example.reminder.dto.User
import com.example.reminder.utils.Utils
import com.example.reminder.veiwmodel.UserViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class CreateNewUser : Fragment(R.layout.fragment_create_new_user) {

    private lateinit var binding: FragmentCreateNewUserBinding
    private val viewModel: UserViewModel by viewModels()
    private lateinit var statusChoice: User.Status
    private lateinit var vDateBirth: TextInputEditText




    private var lastName: String = ""
    private var firstName: String = ""
    private var middleName: String = ""


    lateinit var tvDataPicker: TextInputEditText
    private var dataString = ""

    //
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setHasOptionsMenu(true)
//        return super.onCreate(savedInstanceState)
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateNewUserBinding.bind(view)



        binding.createDateBirthTextInputEditText.setOnClickListener {
            findNavController().navigate(R.id.action_createNewUser_to_calendarFragment)
        }


//        val dateBirthArgs = arguments?.getString("date")
//        binding.createDateBirthTextInputEditText.setText(dateBirthArgs)

            /** Календарь **/
            val calendar = Calendar.getInstance()
            vDateBirth = binding.createDateBirthTextInputEditText
            val dateBirth =
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, month)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    Utils.updateDateLabel(calendar, vDateBirth)
                }
            vDateBirth.setOnClickListener {
                DatePickerDialog(
                    this.requireContext(),
                    dateBirth,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).apply {
                    this.datePicker.minDate = (0)
                }.show()
            }

        lifecycleScope.launch {
            val adapter = ArrayAdapter(
                requireContext(),
                R.layout.menu_item,
                viewModel.statuses
            )
            binding.eventDropMenuAutoCompleteTextView.apply {
                setAdapter(adapter)
                setOnItemClickListener { _, _, position, _ ->
                    statusChoice = viewModel.statuses[position]
                }
            }
        }


        binding.saveButton.setOnClickListener {
            val createUser = User(
                id = null,
                lastName = Utils.fullUserNameGenerator(
                    binding.lastNameTextInputEditText.text.toString(),
                    binding.firstNameTextInputEditText.text.toString(),
                    binding.middleNameTextInputEditText.text.toString()
                ),
                dateBirth = vDateBirth.text.toString(),
                event = statusChoice
            )
            viewModel.createUser(createUser)
            findNavController().navigateUp()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
       // return binding.root
    }


    private fun showErrorToast(text: Int) {
        Toast.makeText(
            requireContext(),
            text,
            Toast.LENGTH_LONG
        ).show()
    }
}
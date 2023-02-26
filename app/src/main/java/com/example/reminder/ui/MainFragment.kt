package com.example.reminder.ui




import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reminder.R
import com.example.reminder.adapter.UserAdapter
import com.example.reminder.databinding.FragmentMainBinding
import com.example.reminder.dto.User
import com.example.reminder.utils.Utils
import com.example.reminder.veiwmodel.UserViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    private var userAdapter:UserAdapter? = null
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding: FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.containerCustomAppBar.addEventBtnMA.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_createNewUser)
        }
        //var tempList = viewModel.data

        val tempList = emptyList<User>()
       tempList.plus(viewModel.data)
//        tempList.add("Второй")
//        tempList.add("Третий")
//        tempList.add("Четвертый")

        binding.recyclerViewMA.setHasFixedSize(true)
        binding.recyclerViewMA.setItemViewCacheSize(13)//размер кэша для количества музыки
        binding.recyclerViewMA.layoutManager = LinearLayoutManager(requireContext())//привязка верстки
        userAdapter = UserAdapter(requireContext(), tempList) //передача списка музыки в адптер
        binding.recyclerViewMA.adapter = userAdapter//приравнивание адаптеров


//            val mainMenu = PopupMenu(
//                context,
//                binding.containerCustomAppBar.mainMenuImageButton
//            )
//            mainMenu.inflate(R.menu.menu_main)
//
//            binding.containerCustomAppBar.mainMenuImageButton.setOnClickListener {
//                mainMenu.show()
//            }

//            mainMenu.setOnMenuItemClickListener {
//                when (it.itemId) {
//                    R.id.menu_item_event -> {
////                        findNavController().navigate(R.id.action_patientListFragment_to_mainFragment)
//                        true
//                    }
//                    R.id.menu_item_setting -> {
////                        findNavController().navigate(R.id.action_patientListFragment_to_claimListFragment)
//                        true
//                    }
//                    else -> {
//                        false
//                    }
//                }
//            }


       // return binding.root
    }

}

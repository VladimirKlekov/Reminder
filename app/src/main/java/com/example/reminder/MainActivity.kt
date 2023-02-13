package com.example.reminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.reminder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addEventBtnMA.setOnClickListener {
           // findNavController().navigate(R.id.action_patientListFragment_to_our_mission_fragment)

            val intent = Intent(this@MainActivity, F::class.java)
//            intent.putExtra("index", 0)
//            intent.putExtra("class","MainActivity")
            startActivity(intent)


        }





    }
}
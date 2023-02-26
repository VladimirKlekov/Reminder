package com.example.reminder.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reminder.databinding.ItemEventBinding
import com.example.reminder.dto.User

class UserAdapter(
    private val context: Context,
    private var userListAdapter: List<User>
) :
    RecyclerView.Adapter<UserAdapter.MyUserHolder>() {


    class MyUserHolder(binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.lastNameTextView
        val event = binding.nameEventTextView
        val dateBirth = binding.dateEventTextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserHolder {
        return MyUserHolder(
            ItemEventBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyUserHolder, position: Int) {
        holder.name.text = userListAdapter[position].lastName

    }

    override fun getItemCount(): Int {
        return userListAdapter.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMusicList(userList: ArrayList<User>) {
        userListAdapter = emptyList()
        userListAdapter.plus(userList)
        notifyDataSetChanged()
    }

}
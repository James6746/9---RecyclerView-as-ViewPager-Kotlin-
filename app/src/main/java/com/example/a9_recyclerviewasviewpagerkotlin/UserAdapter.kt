package com.example.a6_recyclerviewinsidenestedscrollviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a9_recyclerviewasviewpagerkotlin.R
import java.util.ArrayList

class UserAdapter(var context: Context, private val userArrayList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userArrayList[position]
        (holder as UserViewHolder).userName.setText(user.name)
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    internal class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userName = itemView.findViewById<TextView>(R.id.item_name)
    }
}
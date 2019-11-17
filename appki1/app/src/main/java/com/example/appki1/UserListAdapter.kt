package com.example.appki1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_row.view.*

class UserListAdapter(val users: MutableList<User>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        view.setOnClickListener{view.user_id.setTextColor(Color.GREEN)}
        return ViewHolder(view)
    }

    override fun getItemCount(): Int{
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user = users[position]
        holder.userIDText.text = user.ajdi.toString()
        holder.userNameText.text = user.name
        holder.userSurnameText.text = user.forename //powaliło mi się
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val userIDText = view.findViewById<TextView>(R.id.user_id)
        val userNameText = view.findViewById<TextView>(R.id.forename)
        val userSurnameText = view.findViewById<TextView>(R.id.surname)
    }
}

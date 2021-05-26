package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.db.Task



/**
 * Created by Manasa on 26,May,2021
 */
class TodoAdapater(val itemsList: List<Task>) : RecyclerView.Adapter<TodoAdapater.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.todo_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = itemsList[position]
        holder.textView.text = task.data
        holder.checkBox.isChecked = task.isChecked
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)
        val textView = itemView.findViewById<TextView>(R.id.textview)
    }
}
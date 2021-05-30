package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.db.Task
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


/**
 * Created by Manasa on 26,May,2021
 */
class TodoAdapater(private var oldData: List<Task>) :
    RecyclerView.Adapter<TodoAdapater.ViewHolder>() {

    private val clickListener = MutableSharedFlow<Int>()

    fun getClickListener(): SharedFlow<Int> {
        return clickListener.asSharedFlow()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.todo_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = oldData[position]
        holder.textView.text = task.data
        holder.checkBox.isChecked = task.isChecked
        holder.itemView.findViewById<View>(R.id.viewholder).setOnClickListener {
            GlobalScope.launch { clickListener.emit(task.id) }
        }
    }

    fun submitList(itemsList: List<Task>) {
        val newData = itemsList
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return oldData.size
            }

            override fun getNewListSize(): Int {
                return newData.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldData[oldItemPosition].id == newData[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldData[oldItemPosition] == newData[newItemPosition]
            }

        }).dispatchUpdatesTo(this)
        oldData = newData
    }

    override fun getItemCount(): Int {
        return oldData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)
        val textView = itemView.findViewById<TextView>(R.id.textview)
        init {
            checkBox.isClickable = false
        }
    }
}
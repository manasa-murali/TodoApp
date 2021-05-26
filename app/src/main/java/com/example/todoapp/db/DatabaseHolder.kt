package com.example.todoapp.db

import android.content.Context
import androidx.room.Room

/**
 * Created by Manasa on 26,May,2021
 */
object DatabaseHolder {
     var todoDatabase: TodoDatabase? = null
        get() {
            if (field == null) {
                throw RuntimeException("Database not initialized ")
            } else
                return field
        }

    fun initialize(context: Context) {
        todoDatabase = Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db")
            .build()
    }
}
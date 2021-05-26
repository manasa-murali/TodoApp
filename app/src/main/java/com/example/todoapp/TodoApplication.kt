package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.db.DatabaseHolder
import com.example.todoapp.db.TodoDatabase

/**
 * Created by Manasa on 26,May,2021
 */
class TodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseHolder.initialize(this)
    }



}
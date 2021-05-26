package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.db.DatabaseHolder
import com.example.todoapp.db.Task
import com.example.todoapp.db.TodoDao
import com.example.todoapp.db.TodoDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
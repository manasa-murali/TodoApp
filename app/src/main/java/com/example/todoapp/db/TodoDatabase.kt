package com.example.todoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Manasa on 26,May,2021
 */
@Database(entities = [Task::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao
}
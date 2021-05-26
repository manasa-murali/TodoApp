package com.example.todoapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Manasa on 26,May,2021
 */

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val data: String,

    val isChecked: Boolean

)
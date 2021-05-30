package com.example.todoapp.db

import androidx.lifecycle.LiveData

/**
 * Created by Manasa on 26,May,2021
 */
interface IRepository {

    suspend fun insert(task: Task)

    suspend fun delete(id: Int)

    fun getAllTasks(): LiveData<List<Task>>

    suspend fun changeState(id: Int)
}
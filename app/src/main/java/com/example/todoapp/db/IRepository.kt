package com.example.todoapp.db

/**
 * Created by Manasa on 26,May,2021
 */
interface IRepository {

    fun insert(task: Task)

    fun delete(id: Int)

    fun getAllTasks(): List<Task>

    fun changeState(state: Boolean, id: Int)
}
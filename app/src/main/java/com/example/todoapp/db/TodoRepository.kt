package com.example.todoapp.db

import androidx.lifecycle.LiveData

/**
 * Created by Manasa on 26,May,2021
 */
class TodoRepository(private val todoDB: TodoDatabase) : IRepository {
    override suspend fun insert(task: Task) {
        todoDB.getTodoDao().insert(task)
    }

    override suspend fun delete(id: Int) {
        todoDB.getTodoDao().delete(id)
    }

    override fun getAllTasks(): LiveData<List<Task>> {
        return todoDB.getTodoDao().getAllTasks()
    }

    override suspend fun changeState(id: Int) {
        todoDB.getTodoDao().changeState( id)
    }
}
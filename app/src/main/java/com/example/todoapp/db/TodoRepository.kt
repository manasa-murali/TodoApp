package com.example.todoapp.db

/**
 * Created by Manasa on 26,May,2021
 */
class TodoRepository(val todoDB: TodoDatabase) : IRepository {
    override fun insert(task: Task) {
        todoDB.getTodoDao().insert(task)
    }

    override fun delete(id: Int) {
        todoDB.getTodoDao().delete(id)
    }

    override fun getAllTasks(): List<Task> {
        return todoDB.getTodoDao().getAllTasks()
    }

    override fun changeState(state: Boolean, id: Int) {
        todoDB.getTodoDao().changeState(state, id)
    }
}
package com.example.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.db.TodoRepository

/**
 * Created by Manasa on 26,May,2021
 */
class TodoViewModelFactory(private val todoRepository: TodoRepository)  : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(todoRepository) as T
    }
}
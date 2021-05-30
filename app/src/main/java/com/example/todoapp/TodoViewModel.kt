package com.example.todoapp

import androidx.lifecycle.*
import com.example.todoapp.db.Task
import com.example.todoapp.db.TodoRepository
import kotlinx.coroutines.launch

/**
 * Created by Manasa on 26,May,2021
 */
class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {
    val allTask : LiveData<List<Task>> = todoRepository.getAllTasks()

    fun performAction(actionType: ActionType) {
        when (actionType) {
            is ActionType.Delete -> {
                viewModelScope.launch {
                    todoRepository.delete(actionType.id)
                }
            }
            is ActionType.Insert -> {
               viewModelScope.launch {
                    todoRepository.insert(actionType.task)
                }
            }
            is ActionType.MarkState -> {
                viewModelScope.launch {
                    todoRepository.changeState(actionType.id)
                }
            }

        }
    }

    sealed class ActionType {
        data class Insert(val task: Task) : ActionType()
        data class Delete(val id: Int) : ActionType()
        data class MarkState(val id: Int) : ActionType()
   //     object Retrieve: ActionType()

    }

}
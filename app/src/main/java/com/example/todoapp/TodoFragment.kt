package com.example.todoapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.db.DatabaseHolder
import com.example.todoapp.db.Task
import com.example.todoapp.db.TodoRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TodoFragment : Fragment(R.layout.fragment_todo) {


    private val viewModel: TodoViewModel by viewModels {
        TodoViewModelFactory(TodoRepository(DatabaseHolder.todoDatabase!!))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.todoList)
        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = recyclerView.adapter
        if (adapter == null) {
            adapter = TodoAdapater(emptyList())
            recyclerView.adapter = adapter
        }

        lifecycleScope.launch {
            (adapter as TodoAdapater).getClickListener().collect {
                viewModel.performAction(TodoViewModel.ActionType.MarkState(it))
            }
        }

        viewModel.allTask.observe(viewLifecycleOwner, Observer {
            (adapter as TodoAdapater).submitList(it)
        })

        view.findViewById<Button>(R.id.add).setOnClickListener {
            val editText = view.findViewById<EditText>(R.id.edittext)
            if (!TextUtils.isEmpty(editText.text)) {
                viewModel.performAction(
                    TodoViewModel.ActionType.Insert(
                        Task(
                            data = editText.text.toString(),
                            isChecked = false
                        )
                    )
                )
            }
        }

    }

}
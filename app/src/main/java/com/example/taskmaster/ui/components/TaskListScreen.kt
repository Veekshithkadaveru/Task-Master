package com.example.taskmaster.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.taskmaster.viewmodel.TaskViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskListScreen(viewModel: TaskViewModel, onAddTask: () -> Unit) {

    Scaffold(floatingActionButton = {
        AddTaskButton(onClick = onAddTask)
    }) {

        val tasks by viewModel.tasks.collectAsState(initial = emptyList())

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks.size) { index ->
                val task = tasks[index]
                TaskCard(task = task, onDelete = { viewModel.deleteTask(task) }) {
                }
            }
        }
    }
}
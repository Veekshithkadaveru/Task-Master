package com.example.taskmaster.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmaster.model.Task
import com.example.taskmaster.model.TaskDao
import com.example.taskmaster.repository.TaskRepository
import com.example.taskmaster.viewmodel.TaskViewModel

@Composable
fun AddTaskScreen(viewModel: TaskViewModel, onTaskAdded: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isFormVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(text = "Add a New Task", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(8.dp))

        AnimatedVisibility(visible = isFormVisible, enter = fadeIn(), exit = fadeOut()) {
            Column {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    viewModel.addTask(
                        Task(
                            title = title,
                            description = description
                        )
                    )
                    onTaskAdded()
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Save Task")
                }
            }
        }
    }
}
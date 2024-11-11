package com.example.taskmaster

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskmaster.ui.components.AddTaskScreen
import com.example.taskmaster.ui.components.TaskListScreen
import com.example.taskmaster.viewmodel.TaskViewModel

@Composable
fun AppNavigation(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "taskList") {
        composable("taskList") {
            TaskListScreen(viewModel = viewModel, onAddTask = { navController.navigate("addTask") })
        }

        composable("addTask") {
            AddTaskScreen(viewModel = viewModel, onTaskAdded = { navController.popBackStack() })
        }
    }
}
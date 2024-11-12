package com.example.taskmaster.repository

import com.example.taskmaster.model.Task
import com.example.taskmaster.model.TaskDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    fun getTasks(): Flow<List<Task>> = taskDao.getTasks()
}
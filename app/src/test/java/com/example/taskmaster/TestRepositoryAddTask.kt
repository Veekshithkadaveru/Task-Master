package com.example.taskmaster

import com.example.taskmaster.model.Task
import com.example.taskmaster.model.TaskDao
import com.example.taskmaster.repository.TaskRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestRepositoryAddTask {
    private val taskDao: TaskDao = mockk(relaxed = true)
    private val taskRepository = TaskRepository(taskDao)

    @Test
    fun `verify addTask calls insertTask on TaskDao`() = runTest {

        val task = Task(id = 1, title = "New Task", description = "Description")

        taskRepository.insertTask(task)

        coVerify { taskDao.insertTask(task) }

    }
}
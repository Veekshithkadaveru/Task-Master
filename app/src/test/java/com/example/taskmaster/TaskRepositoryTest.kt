package com.example.taskmaster

import com.example.taskmaster.model.Task
import com.example.taskmaster.model.TaskDao
import com.example.taskmaster.repository.TaskRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TaskRepositoryTest {

    private lateinit var taskRepository: TaskRepository
    private val taskDao: TaskDao = mockk()

    @Before
    fun setUp() {
        taskRepository = TaskRepository(taskDao)
    }

    @Test
    fun `verify getTasks returns flow of tasks`() = runTest {

        val taskList = listOf(Task(id = 1, title = "Test Task", description = "Test Description"))
        coEvery { taskDao.getTasks() } returns flowOf(taskList)

        val tasksFlow = taskRepository.getTasks()

        tasksFlow.collect { tasks ->
            assertEquals(taskList, tasks)
        }
    }
}
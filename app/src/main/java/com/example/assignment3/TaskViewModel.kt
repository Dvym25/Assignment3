package com.example.assignment3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>(emptyList())
    val tasks: LiveData<List<Task>> get() = _tasks

    fun addTask(task: Task) {
        val updatedTasks = _tasks.value?.toMutableList() ?: mutableListOf()
        updatedTasks.add(task)
        _tasks.value = updatedTasks
    }
}
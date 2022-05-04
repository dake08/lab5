package com.example.todo_mvvm.model.repository

import com.example.todo_mvvm.model.ApiInterface
import com.example.todo_mvvm.model.Task
import retrofit2.Call

class TaskRepository() {
    fun getAllTasks() : Call<List<Task>> = ApiInterface.create().getTasks()
}
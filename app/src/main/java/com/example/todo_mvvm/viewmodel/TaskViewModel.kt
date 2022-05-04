package com.example.todo_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.todo_mvvm.model.Task
import com.example.todo_mvvm.model.repository.TaskRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskViewModel(application: Application) : AndroidViewModel(application){

    private val repository : TaskRepository = TaskRepository()

    val taskList = MutableLiveData<List<Task>>()

    init {
        getAllTasks()
    }

    private fun getAllTasks() {
        val response = repository.getAllTasks()
        response.enqueue(object : Callback<List<Task>> {
            override fun onResponse(call: Call<List<Task>>, response: Response<List<Task>>) {
                taskList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Task>>, t: Throwable) {
            }
        })
    }

}
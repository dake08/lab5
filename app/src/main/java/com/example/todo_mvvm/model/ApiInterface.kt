package com.example.todo_mvvm.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("todos")
    fun getTasks() : Call<List<Task>>

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}
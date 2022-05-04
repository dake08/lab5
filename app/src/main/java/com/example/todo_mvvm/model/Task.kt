package com.example.todo_mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Task(
    @SerializedName("completed") val completed: Boolean,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
) : Serializable
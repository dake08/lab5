package com.example.todo_mvvm.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter

import com.example.todo_mvvm.R

@SuppressLint("SetTextI18n")
@BindingAdapter("setPriority")
fun setPriority(view: TextView, priority: Boolean){
    when(priority){
        true -> {
            view.text = "Completed"
            view.setTextColor(ResourcesCompat.getColor(view.resources, R.color.blue_1, null))
        }
        false -> {
            view.text = "Not completed"
            view.setTextColor(Color.RED)
        }
    }
}
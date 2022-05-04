package com.example.todo_mvvm.ui.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_mvvm.R
import com.example.todo_mvvm.viewmodel.TaskViewModel
import com.example.todo_mvvm.databinding.AddFragmentBinding
import com.example.todo_mvvm.model.Task

class AddFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = AddFragmentBinding.inflate(inflater)

        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priorities)
        )

        binding.apply {
            btnAdd.setOnClickListener {
                if(TextUtils.isEmpty((edtTask.text))){
                    Toast.makeText(requireContext(), "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val title_str = edtTask.text.toString()
                var completed:Boolean = false

                val taskEntry = Task(
                    completed,
                    0,
                    title_str,
                )

                Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            }
        }

        return binding.root
    }

}
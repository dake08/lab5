package com.example.todo_mvvm.ui.tasks

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_mvvm.databinding.TasksFragmentBinding
import com.example.todo_mvvm.viewmodel.TaskViewModel

class TaskFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = TasksFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        adapter = TaskAdapter(TaskClickListener { taskEntry ->
            findNavController().navigate(
                TaskFragmentDirections.actionTaskFragmentToUpdateFragment(
                    taskEntry
                )
            )
        })

        viewModel.taskList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.apply {

            binding.recyclerView.adapter = adapter

        }

        setHasOptionsMenu(true)

        return binding.root
    }

}
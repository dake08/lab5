package com.example.todo_mvvm.ui.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_mvvm.R
import com.example.todo_mvvm.viewmodel.TaskViewModel
import com.example.todo_mvvm.databinding.UpdateFragmentBinding
import com.example.todo_mvvm.model.Task


class UpdateFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = UpdateFragmentBinding.inflate(inflater)

        val args = UpdateFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            updateEdtTask.setText(args.taskEntry.title)
            updateSpinner.setSelection(if (args.taskEntry.completed) 0 else 1 )

            btnUpdate.setOnClickListener {
                if(TextUtils.isEmpty(updateEdtTask.text)){
                    Toast.makeText(requireContext(), "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val task_str = updateEdtTask.text
                var completed = true
                if (updateSpinner.selectedItemPosition == 0 ) {
                    completed = true
                }
                else if(updateSpinner.selectedItemPosition == 1 ) completed = false

                val taskEntry = Task(
                    completed,
                    args.taskEntry.id,
                    task_str.toString(),
                    )

                Toast.makeText(requireContext(), "Updated!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateFragment_to_taskFragment)
            }
        }

        return binding.root
    }

}
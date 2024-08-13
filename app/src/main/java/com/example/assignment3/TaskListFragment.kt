package com.example.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class TaskListFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var txtTaskList: TextView
    private lateinit var btnAddTask: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_list, container, false)
        txtTaskList = view.findViewById(R.id.txt_task_list)
        btnAddTask = view.findViewById(R.id.btn_add_task)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskViewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)
        taskViewModel.tasks.observe(viewLifecycleOwner, Observer { tasks ->
            if (tasks.isNotEmpty()) {
                txtTaskList.text = tasks.joinToString("\n") { "${it.name} - ${it.priority}" }
            } else {
                txtTaskList.text = "Your Song Playlist Will Appear Below"
            }
        })

        btnAddTask.setOnClickListener {
            (activity as MainActivity).replaceFragment(AddTaskFragment())
        }
    }
}

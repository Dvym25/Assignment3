package com.example.assignment3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TaskDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val taskName = intent.getStringExtra("EXTRA_TASK_NAME")
        val priority = intent.getStringExtra("EXTRA_PRIORITY")
        val mediaType = intent.getStringExtra("EXTRA_MEDIA_TYPE")

        val txtTaskDetails = findViewById<TextView>(R.id.txt_task_details)
        txtTaskDetails.text = "Task Name: $taskName\nPriority: $priority\nMedia Type: $mediaType"
    }
}

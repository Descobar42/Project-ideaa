package com.example.uanpendingtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskName: TextView = view.findViewById(R.id.tvTaskName)
        val taskDescription: TextView = view.findViewById(R.id.tvTaskDescription)
        val taskDueDate: TextView = view.findViewById(R.id.tvDueDate)
        val taskRemaining: TextView = view.findViewById(R.id.tvRemainingTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskName.text = task.name
        holder.taskDescription.text = task.description
        holder.taskDueDate.text = "Fecha de entrega: ${task.dueDate}"
        holder.taskRemaining.text = "Días restantes: ${task.getDaysRemaining()}"
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}


package com.radassa.task.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radassa.task.data.model.Task
import com.radassa.task.databinding.ItemTaskBinding

class TaskAdapter(
    private val taskList: List<Task>) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]
        holder.binding.textDescription.text = task.description
    }

    override fun getItemCount(): Int = taskList.size

    inner class MyViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}
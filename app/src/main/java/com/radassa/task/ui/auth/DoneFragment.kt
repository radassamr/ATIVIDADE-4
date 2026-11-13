package com.radassa.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.radassa.task.data.model.Task
import com.radassa.task.databinding.FragmentDoneBinding
import com.radassa.task.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {
    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewTask(getTask())
    }

    private fun initRecyclerViewTask(taskList: List<Task>) {
        taskAdapter = TaskAdapter(taskList)
        binding.recyclerViewDone.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDone.setHasFixedSize(true)
        binding.recyclerViewDone.adapter = taskAdapter
    }

    private fun getTask() = listOf(
        Task(id = "0", description = "Configuração inicial do projeto"),
        Task(id = "1", description = "Criação das telas de autenticação")
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
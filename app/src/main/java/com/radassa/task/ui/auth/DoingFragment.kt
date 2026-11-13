package com.radassa.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.radassa.task.data.model.Task
import com.radassa.task.databinding.FragmentDoingBinding
import com.radassa.task.ui.adapter.TaskAdapter

class DoingFragment : Fragment() {
    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewTask(getTask())
    }

    private fun initRecyclerViewTask(taskList: List<Task>) {
        taskAdapter = TaskAdapter(taskList)
        binding.recyclerViewDoing.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDoing.setHasFixedSize(true)
        binding.recyclerViewDoing.adapter = taskAdapter
    }

    private fun getTask() = listOf(
        Task(id = "0", description = "Desenvolvendo tela de perfil"),
        Task(id = "1", description = "Testando integração com Firebase")
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
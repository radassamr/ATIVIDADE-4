package com.radassa.task.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.radassa.task.databinding.FragmentRecoverAccountBinding
import com.radassa.task.util.initToolbar

class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {
        binding.buttonEnviar.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        val email = binding.editTextEmail.text.toString().trim()

        if (email.isNotBlank()) {
            Toast.makeText(
                requireContext(),
                "Tudo OK!",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                requireContext(),
                "Preencha um email válido!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
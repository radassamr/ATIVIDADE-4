package com.radassa.task.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.radassa.task.R
import com.radassa.task.databinding.FragmentLoginBinding
import com.radassa.task.util.showBottomSheet

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.buttonLogin.setOnClickListener {
            validateData()
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnRecover.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment2)
        }
    }

    private fun validateData() {
        val email = binding.editTextEmail.text.toString().trim()
        val senha = binding.editTextSenha.text.toString().trim()

        if (email.isNotEmpty()) {
            if (senha.isNotEmpty()) {
                // Comentário temporário somente para testar a validação dos dados
                // findNavController().navigate(R.id.action_global_homeFragment)
            } else {
                showBottomSheet(message = R.string.password_empty)
            }
        } else {
            showBottomSheet(message = R.string.email_empty)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
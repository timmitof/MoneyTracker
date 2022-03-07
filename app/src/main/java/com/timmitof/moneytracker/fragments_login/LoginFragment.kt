package com.timmitof.moneytracker.fragments_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.toolbarAuth.toolbarAuthTitle.text = "Login"
        binding.forgotPasswordTransition.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment())
        }
        binding.toolbarAuth.backBtn.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment())
        }
        return binding.root
    }
}
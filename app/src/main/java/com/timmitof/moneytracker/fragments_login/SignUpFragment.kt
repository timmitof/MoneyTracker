package com.timmitof.moneytracker.fragments_login

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.toolbarAuth.toolbarAuthTitle.text = "Sign Up"
        binding.toolbarAuth.backBtn.setOnClickListener {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToOnBoardingFragment())
        }
        return binding.root
    }
}
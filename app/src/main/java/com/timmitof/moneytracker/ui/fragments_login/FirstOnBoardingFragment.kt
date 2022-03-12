package com.timmitof.moneytracker.ui.fragments_login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.HomeActivity
import com.timmitof.moneytracker.databinding.FragmentFirstOnBoardingBinding

class FirstOnBoardingFragment : Fragment() {
    private var _binding: FragmentFirstOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextToSecondOnboarding.setOnClickListener {
            findNavController().navigate(FirstOnBoardingFragmentDirections.actionOnBoardingFragmentToSecondOnBoardingFragment())
        }

        binding.skipFromFirstOnboarding.setOnClickListener {
            startActivity(Intent(requireActivity(), HomeActivity::class.java))
        }
    }
}
package com.timmitof.moneytracker.ui.fragments_login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.timmitof.moneytracker.HomeActivity
import com.timmitof.moneytracker.databinding.FragmentThirdOnBoardingBinding

class ThirdOnBoardingFragment : Fragment() {
    private var _binding: FragmentThirdOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextToHomeActivity.setOnClickListener {
            startActivity(Intent(requireActivity(), HomeActivity::class.java))
        }
    }
}
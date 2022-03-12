package com.timmitof.moneytracker.ui.fragments_transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.FragmentAddIncomeBinding

class AddIncomeFragment : Fragment() {
    private var _binding: FragmentAddIncomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddIncomeBinding.inflate(inflater, container, false)
        binding.toolbar.toolbarFragmentTitle.text = "Income"
        binding.toolbar.backBtn.setColorFilter(resources.getColor(R.color.light100))
        binding.toolbar.toolbarFragmentTitle.setTextColor(resources.getColor(R.color.light100))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(AddIncomeFragmentDirections.actionAddIncomeFragmentToHomeFragment())
        }
    }

}
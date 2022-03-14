package com.timmitof.moneytracker.ui.fragments_transactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.FragmentAddExpenseBinding
import com.timmitof.moneytracker.databinding.FragmentAddIncomeBinding

class AddExpenseFragment : Fragment() {
    private var _binding: FragmentAddExpenseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddExpenseBinding.inflate(inflater, container, false)
        binding.toolbar.toolbarFragmentTitle.text = "Expense"
        binding.toolbar.backBtn.setColorFilter(resources.getColor(R.color.light100))
        binding.toolbar.toolbarFragmentTitle.setTextColor(resources.getColor(R.color.light100))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(AddExpenseFragmentDirections.actionAddExpenseFragmentToHomeFragment())
        }
    }
}
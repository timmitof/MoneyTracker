package com.timmitof.moneytracker.ui.fragments_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.adapters.RecentTransactionsAdapter
import com.timmitof.moneytracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val income = App.instance?.getDatabase()?.IncomeDao()
        val transactions = App.instance?.getDatabase()?.SpendDao()
        binding.recyclerviewRecentTransactions.adapter = RecentTransactionsAdapter(transactions?.getAllSpend()!!, requireActivity())
        binding.incomeSum.text = income?.getSumIncome().toString()
        binding.expensesSum.text = transactions.getSumSpend().toString()
    }
}
package com.timmitof.moneytracker.ui.fragments_main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.AccountsAdapter
import com.timmitof.moneytracker.adapters.ExpenseAdapter
import com.timmitof.moneytracker.adapters.IncomeAdapter
import com.timmitof.moneytracker.databinding.FragmentTransactionsBinding
import com.timmitof.moneytracker.entities.Accounts
import com.timmitof.moneytracker.entities.Expenses
import com.timmitof.moneytracker.entities.Income


class TransactionsFragment : Fragment() {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

}
package com.timmitof.moneytracker.views.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.HistoryAdapter
import com.timmitof.moneytracker.databinding.FragmentTransactionsBinding
import com.timmitof.moneytracker.models.TypeEnum
import com.timmitof.moneytracker.views.settings.SettingsFragmentDirections


class TransactionsFragment : Fragment(), ITransactionFragment {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
        val adapter = dbTransaction?.getAllTransaction()?.let { HistoryAdapter(it) }
        binding.transactionsRecyclerView.adapter = adapter
        binding.filterButton.setOnClickListener {
            setBottomSheetDialog()
        }
    }

    override fun setBottomSheetDialog() {
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()

        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.bottom_sheet_filter, null)
        val clearBtn = view.findViewById<Button>(R.id.clear_filter_btn)
        val incomeSortBtn = view.findViewById<Button>(R.id.filter_by_income_btn)
        val expenseSortBtn = view.findViewById<Button>(R.id.filter_by_expense_btn)
        incomeSortBtn.setOnClickListener {
            val adapterIncome = dbTransaction?.getAllIncomeList()?.let { HistoryAdapter(it) }
            binding.transactionsRecyclerView.adapter = adapterIncome
            dialog.dismiss()
        }
        expenseSortBtn.setOnClickListener {
            val adapterExpense = dbTransaction?.getAllExpenseList()?.let { HistoryAdapter(it) }
            binding.transactionsRecyclerView.adapter = adapterExpense
            dialog.dismiss()
        }
        clearBtn.setOnClickListener {
            val adapterGetAll = dbTransaction?.getAllTransaction()?.let { HistoryAdapter(it) }
            binding.transactionsRecyclerView.adapter = adapterGetAll
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }

}
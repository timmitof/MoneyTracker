package com.timmitof.moneytracker.views.fragments.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.HistoryAdapter
import com.timmitof.moneytracker.databinding.FragmentTransactionsBinding
import com.timmitof.moneytracker.views.BaseFragment


class TransactionsFragment : BaseFragment<FragmentTransactionsBinding>(), ITransactionFragment {

    override fun getViewBinding() = FragmentTransactionsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
        val adapter = dbTransaction?.getAllTransaction()?.let { HistoryAdapter(it) }
        binding.transactionsRecyclerView.adapter = adapter
        binding.toolbar.title.text = "История"
        binding.toolbar.imageButton.setOnClickListener {
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
package com.timmitof.moneytracker.views.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.adapters.HistoryAdapter
import com.timmitof.moneytracker.databinding.FragmentTransactionsBinding


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
        setRecyclerView()
    }

    override fun setRecyclerView() {
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
        binding.transactionsRecyclerView.adapter = HistoryAdapter(dbTransaction?.getAllTransaction()!!)
    }

}
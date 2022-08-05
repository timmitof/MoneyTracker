package com.timmitof.moneytracker.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.Constants.Companion.currency
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.HomeAdapter
import com.timmitof.moneytracker.databinding.FragmentHomeBinding
import com.timmitof.moneytracker.presenters.home.HomePresenter
import com.timmitof.moneytracker.presenters.home.IHomePresenter

class HomeFragment : Fragment(), IHomeFragmentView {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: IHomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        presenter = HomePresenter(this, requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setViews()
        binding.addFab.setOnClickListener {
            presenter.addFabOnClick(requireContext(), binding.addIncomeFab, binding.addExpenseFab, binding.addFab)
        }
    }

    override fun setRecyclerView() {
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
        binding.transactionsRecyclerView.adapter = HomeAdapter(dbTransaction?.getLastTenTransaction()!!)
    }

    override fun setViews() {
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
        val income = dbTransaction?.getAllIncome()
        val expense = dbTransaction?.getAllExpense()
        val balance = "${income!! - expense!!} $currency"
        binding.balanceSum.text = balance
        binding.expenseSum.text = "$expense $currency"
        binding.incomeSum.text = "$income $currency"

        binding.addIncomeFab.setOnClickListener {
            findNavController().navigate(R.id.addIncomeFragment)
        }
        binding.addExpenseFab.setOnClickListener {
            findNavController().navigate(R.id.addExpenseFragment)
        }
    }
}
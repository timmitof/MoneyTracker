package com.timmitof.moneytracker.views.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.Constants.Companion.currency
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.HomeAdapter
import com.timmitof.moneytracker.databinding.FragmentHomeBinding
import com.timmitof.moneytracker.views.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeContract.View {

    private lateinit var presenter: HomeContract.Presenter

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenter(this, requireContext())
        setRecyclerView()
        setViews()
        setupToolBar()
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
            navigateTo(R.id.addIncomeFragment)
        }
        binding.addExpenseFab.setOnClickListener {
            navigateTo(R.id.addExpenseFragment)
        }

        binding.addFab.setOnClickListener {
            presenter.addFabOnClick(binding.addIncomeFab, binding.addExpenseFab, binding.addFab)
        }
    }

    private fun setupToolBar() {
        binding.toolbar.title.text = "Главная"
        binding.toolbar.background.setBackgroundResource(R.color.main_info)
        binding.toolbar.imageButton.setImageResource(R.drawable.ic_notification)
        binding.toolbar.imageButton.setColorFilter(R.color.violet100)
    }
}
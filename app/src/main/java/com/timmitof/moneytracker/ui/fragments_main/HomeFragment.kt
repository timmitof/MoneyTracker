package com.timmitof.moneytracker.ui.fragments_main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.Constants
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.AccountsAdapter
import com.timmitof.moneytracker.adapters.ChooseIconAdapter
import com.timmitof.moneytracker.adapters.ExpenseAdapter
import com.timmitof.moneytracker.adapters.IncomeAdapter
import com.timmitof.moneytracker.databinding.FragmentHomeBinding
import com.timmitof.moneytracker.entities.Accounts
import com.timmitof.moneytracker.entities.Expenses
import com.timmitof.moneytracker.entities.Income

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
        val dbIncome = App.instance?.getDatabase()?.IncomeDao()
        val dbExpense = App.instance?.getDatabase()?.ExpenseDao()
        val dbAccount = App.instance?.getDatabase()?.AccountDao()
        binding.incomeRecyclerview.adapter = IncomeAdapter(dbIncome!!.getAllIncome(), requireActivity())
        binding.accountsRecyclerview.adapter = AccountsAdapter(dbAccount!!.getAllAccount(), requireActivity())
        binding.expenseRecyclerview.adapter = ExpenseAdapter(dbExpense!!.getAllExpenses(), requireActivity())

        binding.addIncomeBtn.setOnClickListener {
            setBottomSheetIncome()
        }
        binding.addExpenseBtn.setOnClickListener {
            setBottomSheetExpense()
        }
        binding.addAccountsBtn.setOnClickListener {
            setBottomSheetAccount()
        }
    }


    fun setBottomSheetIncome() {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val view = layoutInflater.inflate(R.layout.add_category_bottom_sheet, null)

        val negativeButton: Button = view.findViewById(R.id.cancel_category_btn)
        val positiveButton: Button = view.findViewById(R.id.add_category_btn)
        val icon: FloatingActionButton = view.findViewById(R.id.icon_category)
        val title: TextView = view.findViewById(R.id.title_bottom_sheet)
        val name: EditText = view.findViewById(R.id.name_category)
        title.text = "Доходы"

        val db = App.instance?.getDatabase()?.IncomeDao()

        positiveButton.setOnClickListener {
            db?.addIncome(Income(null, R.drawable.ic_transaction, name.text.toString(), 0))
            Log.e("Added Income: ", "${db?.getAllIncome()}")
            dialog.dismiss()
        }

        icon.setOnClickListener {
            setBottomSheetIcon()
        }

        negativeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(view)
        dialog.show()
    }

    fun setBottomSheetExpense() {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val view = layoutInflater.inflate(R.layout.add_category_bottom_sheet, null)

        val negativeButton: Button = view.findViewById(R.id.cancel_category_btn)
        val positiveButton: Button = view.findViewById(R.id.add_category_btn)
        val icon: FloatingActionButton = view.findViewById(R.id.icon_category)
        val title: TextView = view.findViewById(R.id.title_bottom_sheet)
        val name: EditText = view.findViewById(R.id.name_category)
        title.text = "Расходы"

        val db = App.instance?.getDatabase()?.ExpenseDao()

        positiveButton.setOnClickListener {
            db?.addExpenses(Expenses(null, R.drawable.ic_transaction, name.text.toString(), 0))
            Log.e("Added Expense: ", "${db?.getAllExpenses()}")
            dialog.dismiss()
        }

        icon.setOnClickListener {
            setBottomSheetIcon()
        }

        negativeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(view)
        dialog.show()
    }

    fun setBottomSheetAccount() {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val view = layoutInflater.inflate(R.layout.add_account_bottom_sheet, null)

        val negativeButton: Button = view.findViewById(R.id.cancel_account_btn_bottom_sheet)
        val positiveButton: Button = view.findViewById(R.id.add_account_btn_bottom_sheet)
        val icon: FloatingActionButton = view.findViewById(R.id.icon_account)
        val title: TextView = view.findViewById(R.id.title_account_bottom_sheet)
        val name: EditText = view.findViewById(R.id.name_account)
        val sum: EditText = view.findViewById(R.id.sum_account)
        title.text = "Кошельки"

        val db = App.instance?.getDatabase()?.AccountDao()

        positiveButton.setOnClickListener {
            db?.addAccount(Accounts(null, R.drawable.ic_transaction, name.text.toString(), sum.text.toString().toInt()))
            Log.e("Added Accounts: ", "${db?.getAllAccount()}")
            dialog.dismiss()
        }

        icon.setOnClickListener {
            setBottomSheetIcon()
        }

        negativeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(view)
        dialog.show()
    }

    fun setBottomSheetIcon() {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val view = layoutInflater.inflate(R.layout.choose_icon_bottom_sheet, null)
        val recyclerview: RecyclerView = view.findViewById(R.id.choose_icon_recyclerview)

        recyclerview.adapter = ChooseIconAdapter(Constants.iconArray, requireActivity())

        dialog.setContentView(view)
        dialog.show()
    }
}
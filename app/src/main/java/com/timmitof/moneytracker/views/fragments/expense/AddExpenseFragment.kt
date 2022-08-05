package com.timmitof.moneytracker.views.fragments.expense

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.adapters.SpinnerCategoryAdapter
import com.timmitof.moneytracker.databinding.FragmentAddExpenseBinding
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.TypeEnum
import com.timmitof.moneytracker.views.BaseFragment

class AddExpenseFragment : BaseFragment<FragmentAddExpenseBinding>(), ExpenseContract.View {
    private lateinit var presenter: ExpenseContract.Presenter
    private lateinit var categoryName: String
    private var categoryImage: Int = 0
    private lateinit var categoryDescription: String

    override fun getViewBinding() = FragmentAddExpenseBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ExpensePresenter(this)
        setTopNavigation()
        setCustomSpinner()
        setupView()
    }

    private fun setupView() {
        binding.addExpenseBtn.setOnClickListener {
            if (binding.sumExpense.text.isNullOrBlank()) {
                Toast.makeText(requireContext(), "Заполните поля!", Toast.LENGTH_SHORT).show()
            } else {
                presenter.addExpense(categoryName, TypeEnum.Expense.ordinal, categoryImage, binding.descriptionExpense.text?.toString(), binding.sumExpense.text.toString().toInt())
                Toast.makeText(requireContext(), "Добавлено", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }
    }

    override fun setTopNavigation() {
        binding.topNavigation.title.text = "Расход"
        binding.topNavigation.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun setCustomSpinner() {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val adapter = dbCategory?.getAllCategoryExpense()?.let { SpinnerCategoryAdapter(requireContext(), it) }
        binding.spinnerCategory.adapter = adapter

        binding.spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val item = parent?.getItemAtPosition(position) as Category
                categoryName = item.name
                categoryImage = item.icon!!
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}
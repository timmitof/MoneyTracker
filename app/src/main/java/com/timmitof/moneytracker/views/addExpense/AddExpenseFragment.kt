package com.timmitof.moneytracker.views.addExpense

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.SpinnerCategoryAdapter
import com.timmitof.moneytracker.databinding.FragmentAddExpenseBinding
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.TypeEnum
import com.timmitof.moneytracker.presenters.expense.ExpensePresenter
import com.timmitof.moneytracker.presenters.expense.IExpensePresenter

class AddExpenseFragment : Fragment(), IAddExpenseFragmentView {
    private var _binding: FragmentAddExpenseBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: IExpensePresenter
    private lateinit var categoryName: String
    private var categoryImage: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddExpenseBinding.inflate(inflater, container, false)
        presenter = ExpensePresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTopNavigation()
        setCustomSpinner()

        binding.addExpenseBtn.setOnClickListener {
            presenter.addExpense(categoryName, TypeEnum.Expense.ordinal, categoryImage, binding.descriptionExpense.text?.toString(), binding.sumExpense.text.toString().toInt())

        }
    }

    override fun setTopNavigation() {
        binding.topNavigation.title.text = "Расход"
        binding.topNavigation.backBtn.setOnClickListener {
            AddExpenseFragmentDirections.actionAddExpenseFragmentToHomeFragment()
        }
    }

    override fun setCustomSpinner() {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val adapter = dbCategory?.getAllCategory()?.let { SpinnerCategoryAdapter(requireContext(), it) }
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
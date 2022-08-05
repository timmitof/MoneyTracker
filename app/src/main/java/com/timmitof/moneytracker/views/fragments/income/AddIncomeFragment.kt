package com.timmitof.moneytracker.views.fragments.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.adapters.SpinnerCategoryAdapter
import com.timmitof.moneytracker.databinding.FragmentAddIncomeBinding
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.TypeEnum
import com.timmitof.moneytracker.views.BaseFragment

class AddIncomeFragment : BaseFragment<FragmentAddIncomeBinding>(), IncomeContract.View {
    private lateinit var presenter: IncomeContract.Presenter
    private lateinit var categoryName: String
    private var categoryImage: Int = 0

    override fun getViewBinding() = FragmentAddIncomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = IncomePresenter(this)
        setTopNavigation()
        setCustomSpinner()
        setupView()
    }

    private fun setupView() {
        binding.addIncomeBtn.setOnClickListener {
            val sum = binding.sumIncome.text.toString()
            val description = binding.descriptionIncome.text.toString()
            presenter.addIncome(category = categoryName,
                type = TypeEnum.Income.ordinal,
                image = categoryImage,
                description = description,
                sum = sum,
                result = { text, navigate ->
                    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
                    if (navigate) findNavController().navigateUp()
                })
        }
    }

    override fun setTopNavigation() {
        binding.topNavigation.title.text = "Доход"
        binding.topNavigation.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun setCustomSpinner() {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val adapter =
            dbCategory?.getAllCategoryIncome()?.let { SpinnerCategoryAdapter(requireContext(), it) }
        binding.spinnerCategory.adapter = adapter

        binding.spinnerCategory.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    val item = parent?.getItemAtPosition(position) as Category
                    categoryName = item.name
                    categoryImage = item.icon!!
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
    }
}
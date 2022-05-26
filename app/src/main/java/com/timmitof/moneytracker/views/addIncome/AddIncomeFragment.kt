package com.timmitof.moneytracker.views.addIncome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.Constants
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.SpinnerCategoryAdapter
import com.timmitof.moneytracker.databinding.FragmentAddIncomeBinding
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.Transaction
import com.timmitof.moneytracker.models.TypeEnum
import com.timmitof.moneytracker.presenters.income.IIncomePresenter
import com.timmitof.moneytracker.presenters.income.IncomePresenter

class AddIncomeFragment : Fragment(), IAddIncomeFragmentView {
    private var _binding: FragmentAddIncomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: IIncomePresenter
    private lateinit var categoryName: String
    private var categoryImage: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddIncomeBinding.inflate(inflater, container, false)
        presenter = IncomePresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTopNavigation()
        setCustomSpinner()

        binding.addIncomeBtn.setOnClickListener {
            presenter.addIncome(categoryName, TypeEnum.Income.ordinal, categoryImage, binding.descriptionIncome.text?.toString(), binding.sumIncome.text.toString().toInt())
        onDestroyView()
        }
    }

    override fun setTopNavigation() {
        binding.topNavigation.title.text = "Доход"
        binding.topNavigation.backBtn.setOnClickListener {
            AddIncomeFragmentDirections.actionAddIncomeFragmentToHomeFragment()
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
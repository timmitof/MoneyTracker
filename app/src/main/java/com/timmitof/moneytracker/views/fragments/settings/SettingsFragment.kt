package com.timmitof.moneytracker.views.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.adapters.DeleteCategoryAdapter
import com.timmitof.moneytracker.databinding.FragmentSettingsBinding
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.TypeEnum
import com.timmitof.moneytracker.views.*

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(), SettingsContract.View {

    private lateinit var presenter: SettingsContract.Presenter

    override fun getViewBinding() = FragmentSettingsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SettingsPresenter(this)
        setRecyclerDelete()
        setupView()
    }

    private fun setupView() {
        binding.addCategoryLayout.setOnClickListener {
            binding.addIncomeLayout.reverseVisibility()
            binding.addExpenseLayout.reverseVisibility()
        }
        binding.deleteCategoryCard.setOnClickListener {
            binding.deleteCategoryRecycler.reverseVisibility()
        }

        binding.addIncomeLayout.setOnClickListener {
            navigateTo(SettingsFragmentDirections.actionSettingsFragmentToAddCategoryFragment(TypeEnum.Income.type))
        }
        binding.addExpenseLayout.setOnClickListener{
            navigateTo(SettingsFragmentDirections.actionSettingsFragmentToAddCategoryFragment(TypeEnum.Expense.type))
        }
    }

    override fun setRecyclerDelete() {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val categories = dbCategory?.getAllCategory()
        val adapter = DeleteCategoryAdapter(categories as ArrayList<Category>) {
            presenter.deleteCategory(it)
        }
        binding.deleteCategoryRecycler.adapter = adapter
    }
}
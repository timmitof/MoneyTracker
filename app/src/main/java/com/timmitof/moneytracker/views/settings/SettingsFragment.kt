package com.timmitof.moneytracker.views.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.DeleteCategoryAdapter
import com.timmitof.moneytracker.databinding.FragmentSettingsBinding
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.presenters.profile.IProfilePresenter
import com.timmitof.moneytracker.presenters.profile.ProfilePresenter

class SettingsFragment : Fragment(), ISettingsFragmentView {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: IProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        presenter = ProfilePresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerDelete()
        binding.addCategoryCard.setOnClickListener {
            visibleChange(binding.incomeCategoryLayout, binding.expenseCategoryLayout)
        }
        binding.deleteCategoryCard.setOnClickListener {
            visibleChange(binding.deleteCategoryRecycler, null)
        }
        binding.incomeCategoryLayout.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToAddCategoryFragment(0))
        }
        binding.expenseCategoryLayout.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToAddCategoryFragment(1))
        }
    }

    override fun setRecyclerDelete() {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val adapter = DeleteCategoryAdapter(dbCategory?.getAllCategory() as ArrayList<Category>)
        binding.deleteCategoryRecycler.adapter = adapter
    }

    override fun visibleChange(view: View, view2: View?) {
        if (view.visibility == View.GONE || view2?.visibility == View.GONE) {
            view.visibility = View.VISIBLE
            view2?.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
            view2?.visibility = View.GONE
        }
    }
}
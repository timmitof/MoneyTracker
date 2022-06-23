package com.timmitof.moneytracker.views.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.DeleteCategoryAdapter
import com.timmitof.moneytracker.adapters.SpinnerCategoryAdapter
import com.timmitof.moneytracker.databinding.FragmentSettingsBinding
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.TypeEnum
import com.timmitof.moneytracker.presenters.profile.IProfilePresenter
import com.timmitof.moneytracker.presenters.profile.ProfilePresenter
import com.timmitof.moneytracker.storage.SharedPreference

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
            setBottomSheetDialog()
        }
        binding.deleteCategoryCard.setOnClickListener {
            if (binding.deleteCategoryRecycler.visibility == View.GONE) {
                binding.deleteCategoryRecycler.visibility = View.VISIBLE
            } else {
                binding.deleteCategoryRecycler.visibility = View.GONE
            }
        }
    }

    override fun setRecyclerDelete() {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val adapter = dbCategory?.getAllCategory()?.let { DeleteCategoryAdapter(it as ArrayList<Category>) }
        binding.deleteCategoryRecycler.adapter = adapter
    }


    override fun setBottomSheetDialog() {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.layout_choose_category, null)
        val incomeBtn = view.findViewById<Button>(R.id.income_choose)
        val expenseBtn = view.findViewById<Button>(R.id.expense_choose)

        incomeBtn.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToAddCategoryFragment(TypeEnum.Income.ordinal))
            dialog.dismiss()
        }
        expenseBtn.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToAddCategoryFragment(TypeEnum.Expense.ordinal))
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }
}
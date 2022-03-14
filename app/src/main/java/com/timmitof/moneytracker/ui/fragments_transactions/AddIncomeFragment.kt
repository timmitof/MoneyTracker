package com.timmitof.moneytracker.ui.fragments_transactions

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.FragmentAddIncomeBinding
import com.timmitof.moneytracker.entities.Income
import java.text.SimpleDateFormat
import java.util.*

class AddIncomeFragment : Fragment() {
    private var _binding: FragmentAddIncomeBinding? = null
    private val binding get() = _binding!!
    var formatDate = SimpleDateFormat("dd MMMM YYYY")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddIncomeBinding.inflate(inflater, container, false)
        binding.toolbar.toolbarFragmentTitle.text = "Income"
        binding.toolbar.backBtn.setColorFilter(resources.getColor(R.color.light100))
        binding.toolbar.toolbarFragmentTitle.setTextColor(resources.getColor(R.color.light100))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbIncome = App.instance?.getDatabase()?.IncomeDao()
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(AddIncomeFragmentDirections.actionAddIncomeFragmentToHomeFragment())
        }
        binding.timeIncome.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(requireContext(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, year)
                    selectDate.set(Calendar.MONTH, monthOfYear)
                    selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val date = formatDate.format(selectDate.time)
                    binding.timeIncome.text = date.toString()
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH))

            datePicker.show()
        }
        binding.saveIncomeBtn.setOnClickListener {
            dbIncome?.addIncome(Income(
                idIncome = null,
                titleIncome = binding.nameIncome.text.toString(),
                descriptionIncome = binding.descriptionIncome.text.toString(),
                sumIncome = binding.sumIncome.text.toString().toInt(),
                timeIncome = binding.timeIncome.text.toString()
            ))
            Log.d("AddIncome", "${dbIncome?.getAllIncome()}")
        }

    }

}
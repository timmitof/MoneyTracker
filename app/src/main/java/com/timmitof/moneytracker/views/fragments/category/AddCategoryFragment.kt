package com.timmitof.moneytracker.views.fragments.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.timmitof.moneytracker.Constants
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.ChooseIconAdapter
import com.timmitof.moneytracker.databinding.FragmentAddCategoryBinding
import com.timmitof.moneytracker.views.BaseFragment

class AddCategoryFragment : BaseFragment<FragmentAddCategoryBinding>(), CategoryContract.View {
    private val args: AddCategoryFragmentArgs by navArgs()

    private lateinit var presenter: CategoryContract.Presenter
    private var imageUrl: Int? = null

    override fun getViewBinding() = FragmentAddCategoryBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CategoryPresenter(this)
        setTopNavigation()
        setupView()
    }

    private fun setupView() {
        binding.addCategoryImage.setOnClickListener {
            setAlertDialog()
        }
        binding.addCategoryBtn.setOnClickListener {
            if (binding.addNameCategory.text.isNullOrBlank() || imageUrl == null) {
                Toast.makeText(requireContext(), "Заполните поля!", Toast.LENGTH_SHORT).show()
            } else {
                presenter.addCategory(
                    binding.addNameCategory.text.toString(),
                    imageUrl,
                    args.typeCategory
                )
                Toast.makeText(requireContext(), "Добавлено", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setTopNavigation() {
        binding.topNavigation.title.text = "Новая категория"
        binding.topNavigation.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun setAlertDialog() {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.fragment_choose_icon, null)
        val addBtn = view.findViewById<Button>(R.id.add_btn)
        val recyclerView: RecyclerView = view.findViewById(R.id.choose_icon_recyclerview)
        val adapter = ChooseIconAdapter(Constants.iconArray)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener {
            binding.addCategoryImage.setImageResource(it)
            imageUrl = it
            dialog.dismiss()
        }

        addBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(view)
        dialog.show()
    }
}
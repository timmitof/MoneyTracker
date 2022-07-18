package com.timmitof.moneytracker.views.addCategory

import android.app.StatusBarManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
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
import com.timmitof.moneytracker.presenters.category.CategoryPresenter
import com.timmitof.moneytracker.presenters.category.ICategoryPresenter

class AddCategoryFragment : Fragment(), IAddCategoryFragmentView {
    private val args: AddCategoryFragmentArgs by navArgs()

    private var _binding: FragmentAddCategoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: ICategoryPresenter
    private var imageUrl: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCategoryBinding.inflate(inflater, container, false)
        presenter = CategoryPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTopNavigation()
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
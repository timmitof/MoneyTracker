package com.timmitof.moneytracker.views.addCategory

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.Constants
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.ChooseIconAdapter
import com.timmitof.moneytracker.databinding.FragmentAddCategoryBinding
import com.timmitof.moneytracker.presenters.category.CategoryPresenter
import com.timmitof.moneytracker.presenters.category.ICategoryPresenter

class AddCategoryFragment : Fragment(), IAddCategoryFragmentView {
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
            presenter.addCategory(binding.addNameCategory.text.toString(), imageUrl)
        }
    }

    override fun setTopNavigation() {
        binding.topNavigation.title.text = "Новая категория"
        binding.topNavigation.backBtn.setOnClickListener {
            findNavController().navigate(AddCategoryFragmentDirections.actionAddCategoryFragmentToHomeFragment())
        }
    }

    override fun setAlertDialog() {
        val alert = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater.inflate(R.layout.fragment_choose_icon, null)
        alert.setView(inflater)
        val adapter = ChooseIconAdapter(Constants.iconArray)
        val negativeButton: ImageView = inflater.findViewById(R.id.back_btn)
        val positiveButton: Button = inflater.findViewById(R.id.add_btn)
        val recyclerView: RecyclerView = inflater.findViewById(R.id.choose_icon_recyclerview)
        val dialog = alert.create()
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener {
            binding.addCategoryImage.setImageResource(it)
            imageUrl = it
            dialog.dismiss()
        }

        negativeButton.setOnClickListener {
            dialog.dismiss()
        }

        positiveButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}
package com.timmitof.moneytracker.views.profile

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.Constants
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.ChooseIconAdapter
import com.timmitof.moneytracker.databinding.FragmentProfileBinding
import com.timmitof.moneytracker.presenters.profile.IProfilePresenter
import com.timmitof.moneytracker.presenters.profile.ProfilePresenter
import com.timmitof.moneytracker.storage.SharedPreference

class ProfileFragment : Fragment(), ProfileFragmentView {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: IProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        presenter = ProfilePresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        binding.editUsername.setOnClickListener {
            setAlertDialog()
        }
    }

    override fun setAlertDialog() {
        val alert = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater.inflate(R.layout.add_username_layout, null)
        alert.setView(inflater)
        val username: EditText = inflater.findViewById(R.id.add_username)
        val negativeButton: Button = inflater.findViewById(R.id.close_btn)
        val positiveButton: Button = inflater.findViewById(R.id.add_username_btn)
        val dialog = alert.create()
        val sharedPreference = SharedPreference(requireContext())
        username.setText(sharedPreference.username)

        negativeButton.setOnClickListener {
            dialog.dismiss()
        }

        positiveButton.setOnClickListener {
            presenter.addProfile(requireContext(), username.text.toString())
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun setView() {
        val sharedPreference = SharedPreference(requireContext())
        binding.username.text = sharedPreference.username
    }
}
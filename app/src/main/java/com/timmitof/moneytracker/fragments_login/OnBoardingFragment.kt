package com.timmitof.moneytracker.fragments_login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.adapters.OnBoardingItemsAdapter
import com.timmitof.moneytracker.databinding.FragmentOnBoardingBinding
import com.timmitof.moneytracker.models.OnBoardingItem

class OnBoardingFragment : Fragment() {
    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var onboardingitemsAdater: OnBoardingItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnBoardingItems()
        binding.singUpTransition.setOnClickListener {
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToSignUpFragment())
        }

        binding.loginTransition.setOnClickListener {
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToLoginFragment())
        }
    }

    private fun setOnBoardingItems(){
        onboardingitemsAdater = OnBoardingItemsAdapter(
            listOf(
                OnBoardingItem(
                    onBoardingImage = R.drawable.variant_gain_total_control_of_your_money,
                    onBoardingTitle = "Gain total control of your money",
                    onBoardingDescription = "Become your own money manager and make every cent count"
                ),
                OnBoardingItem(
                    onBoardingImage = R.drawable.variant_know_where_your_money_goes,
                    onBoardingTitle = "Know where your money goes",
                    onBoardingDescription = "Track your transaction easily, with categories and financial report"
                ),
                OnBoardingItem(
                    onBoardingImage = R.drawable.variant_planning_ahead,
                    onBoardingTitle = "Planning ahead",
                    onBoardingDescription = "Setup your budget for each category so you in control"
                )
            )
        )
        binding.onBoardingViewPager.adapter = onboardingitemsAdater
    }
}
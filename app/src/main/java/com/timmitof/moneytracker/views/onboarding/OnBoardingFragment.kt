package com.timmitof.moneytracker.views.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.timmitof.moneytracker.Constants
import com.timmitof.moneytracker.adapters.OnBoardingItemAdapter
import com.timmitof.moneytracker.databinding.FragmentOnBoardingBinding
import com.timmitof.moneytracker.presenters.onboarding.IOnBoardingPresenter
import com.timmitof.moneytracker.presenters.onboarding.OnBoardingPresenter
import com.timmitof.moneytracker.views.homeActivity.HomeActivity

class OnBoardingFragment : Fragment(), IOnBoardingFragmentView {
    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: IOnBoardingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        presenter = OnBoardingPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
        binding.nextFab.setOnClickListener {
            presenter.onButtonClick(requireActivity(), HomeActivity())
        }
    }

    override fun setViewPager() {
        binding.onboardingViewpager.adapter = OnBoardingItemAdapter(Constants.onBoardingList)
    }
}
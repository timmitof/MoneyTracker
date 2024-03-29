package com.timmitof.moneytracker.views.fragments.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.timmitof.moneytracker.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment())}, 1000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}
package com.timmitof.moneytracker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.viewbinding.ViewBinding
import com.timmitof.moneytracker.views.activity.homeActivity.HomeActivity

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private lateinit var parentActivity : HomeActivity
    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = getViewBinding()
        parentActivity = requireActivity() as HomeActivity
        return binding.root
    }

    abstract fun getViewBinding(): VB

    fun navigateTo(navDirections : NavDirections){
        parentActivity.navigatorByDirections.value = navDirections
    }

    fun navigateTo(@IdRes navId : Int){
        parentActivity.navigatorById.value = navId
    }

}
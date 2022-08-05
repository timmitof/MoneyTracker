package com.timmitof.moneytracker.views.activity.homeActivity

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    val navigatorByDirections = MutableLiveData<NavDirections>()
    val navigatorById = MutableLiveData<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.background = null
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.fragment_container_home)
        binding.bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> binding.bottomNavigation.visibility = View.VISIBLE
                R.id.transactionsFragment -> binding.bottomNavigation.visibility = View.VISIBLE
                R.id.settingsFragment -> binding.bottomNavigation.visibility = View.VISIBLE
                else -> binding.bottomNavigation.visibility = View.GONE
            }
        }
        navigatorByDirections.observe(this) {
            navController.navigate(it)
        }
        navigatorById.observe(this) {
            navController.navigate(it)
        }
    }
}
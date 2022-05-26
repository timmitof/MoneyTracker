package com.timmitof.moneytracker.views.homeActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

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
    }
}
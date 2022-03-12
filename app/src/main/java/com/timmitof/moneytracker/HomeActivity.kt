package com.timmitof.moneytracker

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.timmitof.moneytracker.databinding.ActivityHomeBinding
import com.timmitof.moneytracker.ui.fragments_main.HomeFragmentDirections

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.background = null
        setupBottomNav()
        visibilityBottomNav()

        binding.addMainTransactionBtn.setOnClickListener {
            onAddButtonClicked()
        }
        binding.addExpenseBtn.setOnClickListener {
            onAddButtonClicked()
            findNavController(R.id.fragment_container_home).navigate(HomeFragmentDirections.actionHomeFragmentToAddExpenseFragment())
            visibilityBottomNav()
        }
        binding.addIncomeBtn.setOnClickListener {
            onAddButtonClicked()
            visibilityBottomNav()
            findNavController(R.id.fragment_container_home).navigate(HomeFragmentDirections.actionHomeFragmentToAddIncomeFragment())
        }
        binding.addExchangeBtn.setOnClickListener {
            Toast.makeText(this, "Add Exchange Button Clicked", Toast.LENGTH_SHORT).show()

        }
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.fragment_container_home)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked =! clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked){
            binding.addExchangeBtn.visibility = View.VISIBLE
            binding.addIncomeBtn.visibility = View.VISIBLE
            binding.addExpenseBtn.visibility = View.VISIBLE
        }else {
            binding.addExchangeBtn.visibility = View.INVISIBLE
            binding.addIncomeBtn.visibility = View.INVISIBLE
            binding.addExpenseBtn.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            binding.addExpenseBtn.startAnimation(fromBottom)
            binding.addIncomeBtn.startAnimation(fromBottom)
            binding.addExchangeBtn.startAnimation(fromBottom)
        }else {
            binding.addExpenseBtn.startAnimation(toBottom)
            binding.addIncomeBtn.startAnimation(toBottom)
            binding.addExchangeBtn.startAnimation(toBottom)
        }
    }

    private fun visibilityBottomNav(){
        findNavController(R.id.fragment_container_home).addOnDestinationChangedListener{_, destination, _ ->
            if (destination.id == R.id.fragment_container_home){
                binding.bottomAppBar.visibility = View.INVISIBLE
            } else {
                binding.bottomAppBar.visibility = View.VISIBLE
            }
        }
    }
}
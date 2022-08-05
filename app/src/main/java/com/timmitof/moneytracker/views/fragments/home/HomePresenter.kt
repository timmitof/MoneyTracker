package com.timmitof.moneytracker.views.fragments.home

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.R

class HomePresenter(val view: HomeContract.View, val context: Context): HomeContract.Presenter {
    var clicked = false

    override fun addFabOnClick(incomeFab: FloatingActionButton, expenseFab: FloatingActionButton, addFab: FloatingActionButton) {
        setVisibility(clicked, incomeFab, expenseFab)
        setAnimation(clicked, incomeFab, expenseFab, addFab)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean, incomeFab: FloatingActionButton, expenseFab: FloatingActionButton){
        if (!clicked) {
            incomeFab.visibility = View.VISIBLE
            expenseFab.visibility = View.VISIBLE
        } else {
            incomeFab.visibility = View.INVISIBLE
            expenseFab.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean, incomeFab: FloatingActionButton, expenseFab: FloatingActionButton, addFab: FloatingActionButton){
        val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_open_anim) }
        val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_close_anim) }
        val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.from_bottom_anim) }
        val toBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.to_bottom_anim) }

        if (!clicked) {
            incomeFab.startAnimation(fromBottom)
            expenseFab.startAnimation(fromBottom)
            addFab.startAnimation(rotateOpen)
        } else {
            incomeFab.startAnimation(toBottom)
            expenseFab.startAnimation(toBottom)
            addFab.startAnimation(rotateClose)
        }
    }
}
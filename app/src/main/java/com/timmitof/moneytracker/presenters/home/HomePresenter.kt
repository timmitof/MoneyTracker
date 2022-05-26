package com.timmitof.moneytracker.presenters.home

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.helpers.ActivityUtils
import com.timmitof.moneytracker.views.home.IHomeFragmentView

class HomePresenter(val view: IHomeFragmentView, val context: Context): IHomePresenter {
    var clicked = false

    override fun addFabOnClick(context: Context, incomeFab: FloatingActionButton, expenseFab: FloatingActionButton, categoryFab: FloatingActionButton, addFab: FloatingActionButton) {
        setVisibility(clicked, incomeFab, expenseFab, categoryFab)
        setAnimation(clicked, incomeFab, expenseFab, categoryFab, addFab)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean, incomeFab: FloatingActionButton, expenseFab: FloatingActionButton, categoryFab: FloatingActionButton){
        if (!clicked) {
            incomeFab.visibility = View.VISIBLE
            expenseFab.visibility = View.VISIBLE
            categoryFab.visibility = View.VISIBLE
        } else {
            incomeFab.visibility = View.INVISIBLE
            expenseFab.visibility = View.INVISIBLE
            categoryFab.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean, incomeFab: FloatingActionButton, expenseFab: FloatingActionButton, categoryFab: FloatingActionButton, addFab: FloatingActionButton){
        val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_open_anim) }
        val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_close_anim) }
        val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.from_bottom_anim) }
        val toBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.to_bottom_anim) }

        if (!clicked) {
            incomeFab.startAnimation(fromBottom)
            expenseFab.startAnimation(fromBottom)
            categoryFab.startAnimation(fromBottom)
            addFab.startAnimation(rotateOpen)
        } else {
            incomeFab.startAnimation(toBottom)
            expenseFab.startAnimation(toBottom)
            categoryFab.startAnimation(toBottom)
            addFab.startAnimation(rotateClose)
        }
    }
}
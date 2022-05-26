package com.timmitof.moneytracker.presenters.home

import android.app.Activity
import android.content.Context
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface IHomePresenter {
    fun addFabOnClick(context: Context, incomeFab: FloatingActionButton, expenseFab: FloatingActionButton, categoryFab: FloatingActionButton, addFab: FloatingActionButton)
}
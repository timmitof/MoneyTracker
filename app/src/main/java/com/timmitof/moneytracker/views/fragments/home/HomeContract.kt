package com.timmitof.moneytracker.views.fragments.home

import com.google.android.material.floatingactionbutton.FloatingActionButton

interface HomeContract {

    interface View {
        fun setRecyclerView()

        fun setViews()
    }

    interface Presenter {
        fun addFabOnClick(incomeFab: FloatingActionButton, expenseFab: FloatingActionButton, addFab: FloatingActionButton)
    }

}
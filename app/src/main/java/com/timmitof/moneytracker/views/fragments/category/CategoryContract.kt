package com.timmitof.moneytracker.views.fragments.category

interface CategoryContract {

    interface View {
        fun setTopNavigation()

        fun setAlertDialog()
    }

    interface Presenter {
        fun addCategory(name: String, icon: Int?, type: Int)
    }
}
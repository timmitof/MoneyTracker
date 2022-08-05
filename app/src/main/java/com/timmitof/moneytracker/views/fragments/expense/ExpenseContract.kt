package com.timmitof.moneytracker.views.fragments.expense

interface ExpenseContract {

    interface View {
        fun setTopNavigation()

        fun setCustomSpinner()
    }

    interface Presenter {
        fun addExpense(category: String, type: Int, image: Int, description: String?, sum: Int)
    }
}
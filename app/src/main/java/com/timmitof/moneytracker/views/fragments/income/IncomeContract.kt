package com.timmitof.moneytracker.views.fragments.income

interface IncomeContract {

    interface View {
        fun setTopNavigation()

        fun setCustomSpinner()
    }

    interface Presenter {
        fun addIncome(
            category: String,
            type: Int,
            image: Int,
            description: String,
            sum: String,
            result: (String, Boolean) -> Unit
        )
    }
}
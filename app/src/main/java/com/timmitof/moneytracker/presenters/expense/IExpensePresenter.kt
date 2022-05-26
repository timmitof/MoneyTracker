package com.timmitof.moneytracker.presenters.expense

interface IExpensePresenter {
    fun addExpense(category: String, type: Int, image: Int, description: String?, sum: Int)
}
package com.timmitof.moneytracker.presenters.income

interface IIncomePresenter {
    fun addIncome(category: String, type: Int, image: Int, description: String?, sum: Int)
}
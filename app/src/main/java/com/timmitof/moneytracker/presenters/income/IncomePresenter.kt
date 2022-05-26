package com.timmitof.moneytracker.presenters.income

import android.util.Log
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.models.Transaction
import com.timmitof.moneytracker.views.addIncome.IAddIncomeFragmentView

class IncomePresenter(val view: IAddIncomeFragmentView): IIncomePresenter {
    override fun addIncome(category: String, type: Int, image: Int, description: String?, sum: Int) {
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
        val transaction = Transaction(id = null, category = category, type = type, image = image, description = description, sum = sum)
        dbTransaction?.addTransaction(transaction)
        Log.d("DDDD", "${dbTransaction?.getLastTenTransaction()}")
    }
}
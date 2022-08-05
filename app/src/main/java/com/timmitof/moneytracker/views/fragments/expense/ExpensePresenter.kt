package com.timmitof.moneytracker.views.fragments.expense

import android.util.Log
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.models.Transaction

class ExpensePresenter(val view: ExpenseContract.View): ExpenseContract.Presenter {
    override fun addExpense(category: String, type: Int, image: Int, description: String?, sum: Int) {
        val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
        val transaction = Transaction(id = null, category = category, type = type, image = image, description = description, sum = sum)
        dbTransaction?.addTransaction(transaction)
        Log.d("DDDD", "${dbTransaction?.getLastTenTransaction()}")
    }
}
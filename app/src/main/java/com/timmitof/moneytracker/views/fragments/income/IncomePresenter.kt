package com.timmitof.moneytracker.views.fragments.income

import android.util.Log
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.models.Transaction

class IncomePresenter(val view: IncomeContract.View) : IncomeContract.Presenter {
    override fun addIncome(
        category: String,
        type: Int,
        image: Int,
        description: String,
        sum: String,
        result: (String, Boolean) -> Unit
    ) {
        if (description.isEmpty() && sum.isEmpty()) {
            result.invoke("Заполните поля!", false)
        } else {
            val dbTransaction = App.instance?.getDatabase()?.TransactionDao()
            val transaction = Transaction(
                id = null,
                category = category,
                type = type,
                image = image,
                description = description,
                sum = sum.toInt()
            )
            dbTransaction?.addTransaction(transaction)
            Log.d("IncomePresenter", "${dbTransaction?.getLastTenTransaction()}")
            result.invoke("Добавлено", true)
        }
    }
}
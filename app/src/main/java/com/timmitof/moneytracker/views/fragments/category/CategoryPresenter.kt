package com.timmitof.moneytracker.views.fragments.category

import android.util.Log
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.models.Category

class CategoryPresenter(val view: CategoryContract.View): CategoryContract.Presenter {
    override fun addCategory(name: String, icon: Int?, type: Int) {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val category = Category(null, name, icon, type)
        dbCategory?.addCategory(category)
        Log.d("DDDD", "${dbCategory?.getAllCategory()}")
    }
}
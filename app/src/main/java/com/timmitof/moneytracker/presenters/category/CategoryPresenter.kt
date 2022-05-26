package com.timmitof.moneytracker.presenters.category

import android.util.Log
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.views.addCategory.IAddCategoryFragmentView

class CategoryPresenter(val view: IAddCategoryFragmentView): ICategoryPresenter {
    override fun addCategory(name: String, icon: Int?) {
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val category = Category(null, name, icon)
        dbCategory?.addCategory(category)
        Log.d("DDDD", "${dbCategory?.getAllCategory()}")
    }
}
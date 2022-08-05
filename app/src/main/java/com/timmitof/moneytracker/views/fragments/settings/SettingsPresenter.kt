package com.timmitof.moneytracker.views.fragments.settings

import android.content.Context
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.storage.SharedPreference

class SettingsPresenter(val view: SettingsContract.View): SettingsContract.Presenter {
    override fun addProfile(context: Context,name: String) {
        val sharedPreference = SharedPreference(context)
        sharedPreference.username = name
    }

    override fun deleteCategory(category: Category) {
        App.instance?.getDatabase()?.CategoryDao()?.deleteCategory(category)
    }

}
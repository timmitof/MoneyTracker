package com.timmitof.moneytracker.views.fragments.settings

import android.content.Context
import com.timmitof.moneytracker.models.Category

interface SettingsContract {

    interface View {
        fun setRecyclerDelete()

    }

    interface Presenter {
        fun addProfile(context: Context, name: String)
        fun deleteCategory(category: Category)
    }
}
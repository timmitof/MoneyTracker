package com.timmitof.moneytracker.views.fragments.settings

import android.content.Context
import com.timmitof.moneytracker.storage.SharedPreference

class ProfilePresenter(val view: ISettingsFragmentView): IProfilePresenter {
    override fun addProfile(context: Context,name: String) {
        val sharedPreference = SharedPreference(context)
        sharedPreference.username = name
    }

}
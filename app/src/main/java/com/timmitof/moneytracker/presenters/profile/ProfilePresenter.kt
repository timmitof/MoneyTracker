package com.timmitof.moneytracker.presenters.profile

import android.content.Context
import com.timmitof.moneytracker.storage.SharedPreference
import com.timmitof.moneytracker.views.profile.ProfileFragmentView

class ProfilePresenter(val view: ProfileFragmentView): IProfilePresenter {
    override fun addProfile(context: Context,name: String) {
        val sharedPreference = SharedPreference(context)
        sharedPreference.username = name
    }

}
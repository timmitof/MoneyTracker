package com.timmitof.moneytracker.presenters.profile

import android.content.Context

interface IProfilePresenter {
    fun addProfile(context: Context, name: String)
}
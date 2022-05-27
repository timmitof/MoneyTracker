package com.timmitof.moneytracker.presenters.onboarding

import android.app.Activity
import android.content.Context

interface IOnBoardingPresenter {
    fun startActivity(context: Context, activity: Activity)
}
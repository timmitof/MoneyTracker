package com.timmitof.moneytracker.views.fragments.onboarding

import android.app.Activity
import android.content.Context
import com.timmitof.moneytracker.helpers.ActivityUtils

class OnBoardingPresenter(val view: OnBoardingContract.View): OnBoardingContract.Presenter {
    override fun startActivity(context: Context, activity: Activity) {
        ActivityUtils.startActivity(context, activity)
    }
}
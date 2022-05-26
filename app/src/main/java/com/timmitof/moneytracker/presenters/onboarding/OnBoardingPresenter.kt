package com.timmitof.moneytracker.presenters.onboarding

import android.app.Activity
import android.content.Context
import com.timmitof.moneytracker.helpers.ActivityUtils
import com.timmitof.moneytracker.views.onboarding.IOnBoardingFragmentView

class OnBoardingPresenter(val view: IOnBoardingFragmentView): IOnBoardingPresenter {
    override fun onButtonClick(context: Context, activity: Activity) {
        ActivityUtils.startActivity(context, activity)
    }
}
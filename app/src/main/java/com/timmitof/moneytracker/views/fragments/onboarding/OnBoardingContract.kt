package com.timmitof.moneytracker.views.fragments.onboarding

import android.app.Activity
import android.content.Context

interface OnBoardingContract {

    interface View {
        fun setViewPager()
    }

    interface Presenter {
        fun startActivity(context: Context, activity: Activity)
    }
}
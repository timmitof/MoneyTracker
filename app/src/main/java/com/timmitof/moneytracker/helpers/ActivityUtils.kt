package com.timmitof.moneytracker.helpers

import android.app.Activity
import android.content.Context
import android.content.Intent

object ActivityUtils {
    fun startActivity(context: Context, activity: Activity) {
        val intent = Intent(context, activity::class.java)
        context.startActivity(intent)
    }

    fun startActivity(context: Context, intent: Intent) {
        context.startActivity(intent)
    }
}
package com.timmitof.moneytracker.storage

import android.content.Context

class SharedPreference(context: Context) {
    private val PREFERENCE_FILE = "PrefFile"

    private val APP_PREF_NAME = "Name"
    private val preference = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE)

    var username: String?
        get() = preference.getString(APP_PREF_NAME, null)
        set(value) = preference.edit().putString(APP_PREF_NAME, value).apply()
}
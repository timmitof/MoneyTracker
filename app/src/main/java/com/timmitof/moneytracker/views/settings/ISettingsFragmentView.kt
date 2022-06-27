package com.timmitof.moneytracker.views.settings

import android.view.View

interface ISettingsFragmentView {
    fun setRecyclerDelete()

    fun visibleChange(view: View, view2: View?)
}
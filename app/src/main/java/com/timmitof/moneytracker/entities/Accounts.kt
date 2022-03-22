package com.timmitof.moneytracker.entities

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Accounts (
    @PrimaryKey(autoGenerate = true) val idAccounts: Int?,
    @ColumnInfo(name="iconAccounts") val iconAccounts: Int?,
    @ColumnInfo(name="nameAccounts") val nameAccounts: String?,
    @ColumnInfo(name="sumAccounts") val sumAccounts: Int?,
)
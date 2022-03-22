package com.timmitof.moneytracker.entities

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expenses(
    @PrimaryKey(autoGenerate = true) val idExpenses: Int?,
    @ColumnInfo(name="iconExpenses") val iconExpenses: Int?,
    @ColumnInfo(name="nameExpenses") val nameExpenses: String?,
    @ColumnInfo(name="sumExpenses") val sumExpenses: Int?,
)
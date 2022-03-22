package com.timmitof.moneytracker.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Income(
    @PrimaryKey(autoGenerate = true) val idIncome: Int?,
    @ColumnInfo(name="iconIncome") val iconIncome: Int,
    @ColumnInfo(name="nameIncome") val nameIncome: String?,
    @ColumnInfo(name="sumIncome") val sumIncome: Int?,
)

package com.timmitof.moneytracker.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Income(
    @PrimaryKey(autoGenerate = true) val idIncome: Int?,
    @ColumnInfo(name = "title") val titleIncome: String,
    @ColumnInfo(name = "description") val descriptionIncome: String,
    @ColumnInfo(name = "sum") val sumIncome: Int,
    @ColumnInfo(name = "time") val timeIncome: String
)

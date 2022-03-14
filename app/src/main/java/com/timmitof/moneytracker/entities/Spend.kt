package com.timmitof.moneytracker.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Spend(
    @PrimaryKey(autoGenerate = true) val idSpend: Int,
    @ColumnInfo(name = "title") val titleSpend: String,
    @ColumnInfo(name = "description") val descriptionSpend: String,
    @ColumnInfo(name = "sum") val sumSpend: Int,
    @ColumnInfo(name = "time") val timeSpend: String
)

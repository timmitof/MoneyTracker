package com.timmitof.moneytracker.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Spend(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "sum") val sum: Int,
    @ColumnInfo(name = "time") val time: String
)

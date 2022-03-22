package com.timmitof.moneytracker.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transactions(
    @PrimaryKey(autoGenerate = true) val idTransactions: Int?,
    @ColumnInfo(name="titleTransactions") val titleTransactions: String,
    @ColumnInfo(name="descriptionTransactions") val descriptionTransactions: String,
    @ColumnInfo(name="sumTransactions") val sumTransactions: Int
)

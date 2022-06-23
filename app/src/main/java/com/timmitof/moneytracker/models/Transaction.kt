package com.timmitof.moneytracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Transaction")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val category: String,
    val type: Int,
    val image: Int?,
    val description: String?,
    val sum: Int,
)

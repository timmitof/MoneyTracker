package com.timmitof.moneytracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String,
    val icon: Int?
)

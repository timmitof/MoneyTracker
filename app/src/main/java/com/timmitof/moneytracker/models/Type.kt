package com.timmitof.moneytracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Type")
data class Type (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)

enum class TypeEnum(val type: Int){
    Income(1),
    Expense(2)
}
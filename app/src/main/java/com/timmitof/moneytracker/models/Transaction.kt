package com.timmitof.moneytracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Transaction"
//    foreignKeys =
//    arrayOf(
//        ForeignKey(
//            entity = Category::class,
//            parentColumns = arrayOf("id"),
//            childColumns = arrayOf("category")
//        ),
//        ForeignKey(
//            entity = Type::class,
//            parentColumns = arrayOf("id"),
//            childColumns = arrayOf("type")
//        )
//    )
)
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val category: String,
    val type: Int,
    val image: Int?,
    val description: String?,
    val sum: Int,
)

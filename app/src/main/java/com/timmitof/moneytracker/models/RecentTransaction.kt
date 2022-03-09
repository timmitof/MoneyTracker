package com.timmitof.moneytracker.models

data class RecentTransaction(
    val title: String,
    val description: String,
    val sum: Int,
    val time: String
)

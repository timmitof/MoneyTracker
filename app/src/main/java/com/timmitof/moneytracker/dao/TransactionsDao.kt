package com.timmitof.moneytracker.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.timmitof.moneytracker.entities.Transactions

@Dao
interface TransactionsDao {
    @Insert
    fun addTransaction(transactions: Transactions)

    @Query("SELECT * FROM Transactions")
    fun getAllTransactions(): List<Transactions>

    @Delete
    fun deleteTransactions(transactions: Transactions)
}
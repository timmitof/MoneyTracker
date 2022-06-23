package com.timmitof.moneytracker.dao

import androidx.room.*
import com.timmitof.moneytracker.models.Transaction

@Dao
interface TransactionDao {
    @Insert
    fun addTransaction(transaction: Transaction)

    @Query("SELECT * FROM `Transaction` LIMIT 10")
    fun getLastTenTransaction(): List<Transaction>

    @Query("SELECT * FROM `Transaction`")
    fun getAllTransaction(): List<Transaction>

    @Query("SELECT * FROM `Transaction` WHERE category = 0")
    fun getAllIncomeList(): List<Transaction>

    @Query("SELECT * FROM `Transaction` WHERE category = 1")
    fun getAllExpenseList(): List<Transaction>

    @Query("SELECT SUM(sum) FROM `Transaction`")
    fun getAllSum(): Int

    @Query("SELECT SUM(sum) FROM `Transaction` WHERE type = 0")
    fun getAllIncome(): Int

    @Query("SELECT SUM(sum) FROM `Transaction` WHERE type = 1")
    fun getAllExpense(): Int

    @Update
    fun updateTransaction(transaction: Transaction)

    @Delete
    fun deleteTransaction(transaction: Transaction)
}
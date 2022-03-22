package com.timmitof.moneytracker.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.timmitof.moneytracker.entities.Expenses

@Dao
interface ExpenseDao {
    @Insert
    fun addExpenses(expenses: Expenses)

    @Query("SELECT * FROM Expenses")
    fun getAllExpenses(): List<Expenses>

    @Delete
    fun deleteExpenses(expenses: Expenses)
}
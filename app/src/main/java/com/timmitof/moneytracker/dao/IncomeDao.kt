package com.timmitof.moneytracker.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.timmitof.moneytracker.entities.Income

@Dao
interface IncomeDao {
    @Insert
    fun addIncome(income: Income)

    @Query("SELECT * FROM Income")
    fun getAllIncome(): List<Income>

    @Delete
    fun deleteIncome(income: Income)
}
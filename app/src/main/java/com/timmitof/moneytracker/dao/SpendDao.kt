package com.timmitof.moneytracker.dao

import androidx.room.*
import com.timmitof.moneytracker.entities.Spend

@Dao
interface SpendDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSpend(spend: Spend)

    @Query("SELECT * FROM Spend")
    fun getAllSpend(): List<Spend>

    @Query("SELECT sum FROM Spend")
    fun getSumSpend(): Int

    @Delete
    fun deleteSpend(spend: Spend)
}
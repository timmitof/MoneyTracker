package com.timmitof.moneytracker.dao

import androidx.room.*
import com.timmitof.moneytracker.entities.Spend

@Dao
interface SpendDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSpend(spend: Spend)

    @Query("SELECT * FROM Spend")
    fun getAllSpend(): List<Spend>

    @Delete
    fun deleteSpend(spend: Spend)
}
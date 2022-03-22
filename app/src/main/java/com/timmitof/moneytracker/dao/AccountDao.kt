package com.timmitof.moneytracker.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.timmitof.moneytracker.entities.Accounts

@Dao
interface AccountDao {
    @Insert
    fun addAccount(accounts: Accounts)

    @Query("SELECT * FROM Accounts")
    fun getAllAccount(): List<Accounts>

    @Delete
    fun deleteAccount(accounts: Accounts)
}
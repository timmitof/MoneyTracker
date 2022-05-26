package com.timmitof.moneytracker.dao

import androidx.room.*
import com.timmitof.moneytracker.models.Type

@Dao
interface TypeDao {
    @Insert
    fun addType(type: Type)

    @Query("SELECT * FROM Type")
    fun getAllType(): List<Type>

    @Update
    fun updateType(type: Type)

    @Delete
    fun deleteType(type: Type)
}
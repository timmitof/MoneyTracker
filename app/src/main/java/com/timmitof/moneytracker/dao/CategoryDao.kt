package com.timmitof.moneytracker.dao

import androidx.room.*
import com.timmitof.moneytracker.models.Category

@Dao
interface CategoryDao {
    @Insert
    fun addCategory(vararg category: Category)

    @Query("SELECT * FROM Category")
    fun getAllCategory(): List<Category>

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)
}
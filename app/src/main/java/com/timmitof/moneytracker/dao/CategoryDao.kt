package com.timmitof.moneytracker.dao

import androidx.room.*
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.TypeEnum

@Dao
interface CategoryDao {
    @Insert
    fun addCategory(vararg category: Category)

    @Query("SELECT * FROM Category")
    fun getAllCategory(): List<Category>

    @Query("SELECT * FROM Category WHERE type = 0")
    fun getAllCategoryIncome(): List<Category>

    @Query("SELECT * FROM Category WHERE type = 1")
    fun getAllCategoryExpense(): List<Category>

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)
}
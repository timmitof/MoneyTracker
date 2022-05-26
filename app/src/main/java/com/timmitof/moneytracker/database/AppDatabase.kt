package com.timmitof.moneytracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timmitof.moneytracker.dao.CategoryDao
import com.timmitof.moneytracker.dao.TransactionDao
import com.timmitof.moneytracker.dao.TypeDao
import com.timmitof.moneytracker.models.Category
import com.timmitof.moneytracker.models.Transaction
import com.timmitof.moneytracker.models.Type


@Database(entities = [Category::class, Transaction::class, Type::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun CategoryDao(): CategoryDao
    abstract fun TransactionDao(): TransactionDao
    abstract fun TypeDao(): TypeDao
}
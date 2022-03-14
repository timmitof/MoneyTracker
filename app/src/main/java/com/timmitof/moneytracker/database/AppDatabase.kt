package com.timmitof.moneytracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timmitof.moneytracker.dao.IncomeDao
import com.timmitof.moneytracker.dao.SpendDao
import com.timmitof.moneytracker.entities.Income
import com.timmitof.moneytracker.entities.Spend

@Database(entities = [Spend::class, Income::class], version = 2, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun SpendDao(): SpendDao
    abstract fun IncomeDao(): IncomeDao
}
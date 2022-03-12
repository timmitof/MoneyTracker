package com.timmitof.moneytracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timmitof.moneytracker.dao.SpendDao
import com.timmitof.moneytracker.entities.Spend

@Database(entities = [Spend::class], version = 1, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun SpendDao(): SpendDao
}
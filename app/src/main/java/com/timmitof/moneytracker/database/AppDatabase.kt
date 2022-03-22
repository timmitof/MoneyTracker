package com.timmitof.moneytracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timmitof.moneytracker.dao.AccountDao
import com.timmitof.moneytracker.dao.ExpenseDao
import com.timmitof.moneytracker.dao.IncomeDao
import com.timmitof.moneytracker.dao.TransactionsDao
import com.timmitof.moneytracker.entities.Accounts
import com.timmitof.moneytracker.entities.Expenses
import com.timmitof.moneytracker.entities.Income
import com.timmitof.moneytracker.entities.Transactions

@Database(entities = [Transactions::class, Income::class, Expenses::class, Accounts::class], version = 5, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun TransactionsDao(): TransactionsDao
    abstract fun IncomeDao(): IncomeDao
    abstract fun ExpenseDao(): ExpenseDao
    abstract fun AccountDao(): AccountDao
}
package com.antonharbatovich.financeapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.antonharbatovich.financeapp.data.db.dao.CurrenciesDao
import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

@Database(entities = [CurrencyDb::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun currenciesDao(): CurrenciesDao

    companion object {
        private var db_instance: DataBase? = null

        fun getDataBaseInstance(context: Context): DataBase {
            if (db_instance == null) {
                db_instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return db_instance!!
        }

        private const val DATABASE_NAME = "data_base"
    }

}
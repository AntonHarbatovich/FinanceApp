package com.antonharbatovich.financeapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

@Dao
interface CurrenciesDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertCurrency(currencyDb: CurrencyDb)

    @Delete
    suspend fun deleteCurrency(currencyDb: CurrencyDb)

    @Query("SELECT * FROM CurrencyDb WHERE baseCurrency = :base")
    suspend fun getListCurrencies(base: String): List<CurrencyDb>
}
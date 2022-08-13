package com.antonharbatovich.financeapp.data.db.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

@Dao
interface CurrenciesDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertCurrency(currencyDb: CurrencyDb)

    @Delete
    suspend fun deleteCurrency(currencyDb: CurrencyDb)

    @Query("SELECT * FROM CurrencyDb WHERE baseCurrency = :base")
    suspend fun getListCurrencies(base: String): List<CurrencyDb>

    @Update
    suspend fun updateCurrency(currencyDb: CurrencyDb)
}
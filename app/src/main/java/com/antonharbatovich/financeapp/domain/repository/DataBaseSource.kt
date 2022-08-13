package com.antonharbatovich.financeapp.domain.repository

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

interface DataBaseSource {
    suspend fun insertCurrency(currencyDb: CurrencyDb)
    suspend fun deleteCurrency(currencyDb: CurrencyDb)
    suspend fun getListCurrencies(base: String): List<CurrencyDb>
}
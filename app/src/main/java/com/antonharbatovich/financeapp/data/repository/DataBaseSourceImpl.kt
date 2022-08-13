package com.antonharbatovich.financeapp.data.repository

import com.antonharbatovich.financeapp.data.db.dao.CurrenciesDao
import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import javax.inject.Inject

class DataBaseSourceImpl @Inject constructor(private val currenciesDao: CurrenciesDao) :
    DataBaseSource {
    override suspend fun insertCurrency(currencyDb: CurrencyDb) = currenciesDao.insertCurrency(currencyDb)

    override suspend fun deleteCurrency(currencyDb: CurrencyDb) = currenciesDao.deleteCurrency(currencyDb)

    override suspend fun getListCurrencies(base: String): List<CurrencyDb> =
        currenciesDao.getListCurrencies(base)
}
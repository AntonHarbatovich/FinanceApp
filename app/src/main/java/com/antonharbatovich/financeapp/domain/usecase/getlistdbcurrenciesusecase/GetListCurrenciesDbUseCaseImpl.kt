package com.antonharbatovich.financeapp.domain.usecase.getlistdbcurrenciesusecase

import com.antonharbatovich.financeapp.domain.entity.Currency
import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import javax.inject.Inject

class GetListCurrenciesDbUseCaseImpl @Inject constructor(
    private val dataBaseSource: DataBaseSource
) : GetListCurrenciesDbUseCase {
    override suspend fun invoke(base: String): List<Currency> {
        val listCurrency = mutableListOf<Currency>()
        val listCurrencyDb = dataBaseSource.getListCurrencies(base)
        for (i in listCurrencyDb.indices) {
            listCurrency.add(Currency(listCurrencyDb[i], true))
        }
        return listCurrency
    }
}
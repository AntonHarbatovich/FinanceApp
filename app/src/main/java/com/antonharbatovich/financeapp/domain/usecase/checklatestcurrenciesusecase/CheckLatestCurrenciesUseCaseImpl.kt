package com.antonharbatovich.financeapp.domain.usecase.checklatestcurrenciesusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.entity.Currency

class CheckLatestCurrenciesUseCaseImpl : CheckLatestCurrenciesUseCase {
    override suspend fun invoke(listCurrenciesDb: List<CurrencyDb>): List<Currency> {
        val listCurrencies = mutableListOf<Currency>()
        for (i in listCurrenciesDb.indices) {
            listCurrencies.add(Currency(listCurrenciesDb[i], false))
        }
        return listCurrencies
    }
}
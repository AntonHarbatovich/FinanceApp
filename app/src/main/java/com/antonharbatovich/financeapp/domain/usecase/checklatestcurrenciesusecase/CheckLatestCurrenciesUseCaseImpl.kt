package com.antonharbatovich.financeapp.domain.usecase.checklatestcurrenciesusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.entity.Currency
import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import javax.inject.Inject

class CheckLatestCurrenciesUseCaseImpl @Inject constructor(
    private val dataBaseSource: DataBaseSource
) : CheckLatestCurrenciesUseCase {
    override suspend fun invoke(listLatestCurrencies: List<CurrencyDb>): List<Currency> {
        val listCurrencies = mutableListOf<Currency>()
        var listCurrencyDb = listOf<CurrencyDb>()
        if (listLatestCurrencies.isNotEmpty()) {
            listCurrencyDb = dataBaseSource.getListCurrencies(listLatestCurrencies[0].baseCurrency)
        }
        for (i in listLatestCurrencies.indices) {
            val latestCurrency = listLatestCurrencies[i]
            if(listCurrencyDb.isNotEmpty()){
                for (j in listCurrencyDb.indices) {
                    val currencyDb = listCurrencyDb[j]
                    if (latestCurrency.baseCurrency == currencyDb.baseCurrency && latestCurrency.symbol == currencyDb.symbol) {
                        listCurrencies.add(Currency(listLatestCurrencies[i], true))
                        dataBaseSource.updateCurrency(latestCurrency)
                    } else {
                        listCurrencies.add(Currency(listLatestCurrencies[i], false))
                    }
                }
            } else{
                listCurrencies.add(Currency(listLatestCurrencies[i], false))
            }
        }
        return listCurrencies
    }


}
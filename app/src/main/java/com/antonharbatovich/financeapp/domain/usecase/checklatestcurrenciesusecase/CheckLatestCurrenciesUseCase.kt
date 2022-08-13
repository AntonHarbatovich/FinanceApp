package com.antonharbatovich.financeapp.domain.usecase.checklatestcurrenciesusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.entity.Currency

interface CheckLatestCurrenciesUseCase {
    suspend operator fun invoke(listLatestCurrencies: List<CurrencyDb>): List<Currency>
}
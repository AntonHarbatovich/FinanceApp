package com.antonharbatovich.financeapp.domain.usecase.insertdbcurrencyusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

interface InsertDbCurrencyUseCase {
    suspend operator fun invoke(currencyDb: CurrencyDb)
}
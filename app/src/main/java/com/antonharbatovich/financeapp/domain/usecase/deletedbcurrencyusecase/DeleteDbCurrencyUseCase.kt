package com.antonharbatovich.financeapp.domain.usecase.deletedbcurrencyusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

interface DeleteDbCurrencyUseCase {
    suspend operator fun invoke(currencyDb: CurrencyDb)
}
package com.antonharbatovich.financeapp.domain.usecase.insertdbcurrencyusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import javax.inject.Inject

class InsertDbCurrencyUseCaseImpl @Inject constructor(
    private val dataBaseSource: DataBaseSource
) : InsertDbCurrencyUseCase {
    override suspend fun invoke(currencyDb: CurrencyDb) = dataBaseSource.insertCurrency(currencyDb)
}
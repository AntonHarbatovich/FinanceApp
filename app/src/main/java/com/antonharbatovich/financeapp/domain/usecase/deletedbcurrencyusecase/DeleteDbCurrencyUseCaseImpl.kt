package com.antonharbatovich.financeapp.domain.usecase.deletedbcurrencyusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import javax.inject.Inject

class DeleteDbCurrencyUseCaseImpl @Inject constructor(
    private val dataBaseSource: DataBaseSource
) : DeleteDbCurrencyUseCase {
    override suspend fun invoke(currencyDb: CurrencyDb) = dataBaseSource.deleteCurrency(currencyDb)
}
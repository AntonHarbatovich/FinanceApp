package com.antonharbatovich.financeapp.domain.usecase.getlistdbcurrenciesusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import javax.inject.Inject

class GetListCurrenciesDbUseCaseImpl @Inject constructor(
    private val dataBaseSource: DataBaseSource
) : GetListCurrenciesDbUseCase {
    override suspend fun invoke(base: String): List<CurrencyDb> =
        dataBaseSource.getListCurrencies(base)
}
package com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLatestCurrenciesUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository
) : GetLatestCurrenciesUseCase {
    override suspend fun invoke(base:String): Flow<Result<List<CurrencyDb>>> =
        repository.getLatestCurrencies(base)
}
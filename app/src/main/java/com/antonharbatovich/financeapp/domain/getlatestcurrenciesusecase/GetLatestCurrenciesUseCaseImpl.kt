package com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase

import com.antonharbatovich.financeapp.data.ExchangeRatesResponse
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLatestCurrenciesUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository
) : GetLatestCurrenciesUseCase {
    override suspend fun invoke(): Flow<Result<ExchangeRatesResponse>> =
        repository.getLatestCurrencies()
}
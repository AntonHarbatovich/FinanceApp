package com.antonharbatovich.financeapp.data.repository

import com.antonharbatovich.financeapp.data.Currency
import com.antonharbatovich.financeapp.data.api.ExchangeRatesService
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val service: ExchangeRatesService
) : RemoteRepository {
    override suspend fun getLatestCurrencies(base: String): Flow<Result<List<Currency>>> = flow {
        emit(Result.Loading())
        val response = service.getLatestCurrencies(base)
        if (response.isSuccessful) {
            val currencies: List<Currency> =
                response.body()!!.rates.entries.map { entry ->
                    Currency(response.body()!!.base, entry.key, entry.value)
                }
            emit(Result.Success(currencies))
        } else {
            val errorMessage = response.message()
            emit(Result.Error(errorMessage))
        }
    }
}
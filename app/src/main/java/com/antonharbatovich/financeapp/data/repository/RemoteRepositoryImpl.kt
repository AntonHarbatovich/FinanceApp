package com.antonharbatovich.financeapp.data.repository

import com.antonharbatovich.financeapp.data.ExchangeRatesResponse
import com.antonharbatovich.financeapp.data.api.ExchangeRatesService
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val service: ExchangeRatesService
) : RemoteRepository {
    override suspend fun getLatestCurrencies(): Flow<Result<ExchangeRatesResponse>> = flow {
        emit(Result.Loading())
        val response = service.getLatestCurrencies(USD)
        if (response.isSuccessful) {
            emit(Result.Success(response.body()!!))
        } else {
            val errorMessage = response.message()
            emit(Result.Error(errorMessage))
        }
    }

    companion object {
        const val USD = "USD"
    }
}
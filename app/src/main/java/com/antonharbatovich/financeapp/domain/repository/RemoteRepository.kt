package com.antonharbatovich.financeapp.domain.repository

import com.antonharbatovich.financeapp.data.ExchangeRatesResponse
import com.antonharbatovich.financeapp.domain.entity.Result
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getLatestCurrencies(): Flow<Result<ExchangeRatesResponse>>
}
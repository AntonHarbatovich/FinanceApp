package com.antonharbatovich.financeapp.domain.repository

import com.antonharbatovich.financeapp.data.Currency
import com.antonharbatovich.financeapp.domain.entity.Result
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getLatestCurrencies(base: String): Flow<Result<List<Currency>>>
    suspend fun getSymbols(): Flow<Result<List<String>>>
}
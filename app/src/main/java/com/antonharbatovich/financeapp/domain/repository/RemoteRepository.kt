package com.antonharbatovich.financeapp.domain.repository

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.entity.Result
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getLatestCurrencies(base: String): Flow<Result<List<CurrencyDb>>>
    suspend fun getSymbols(): Flow<Result<List<String>>>
}
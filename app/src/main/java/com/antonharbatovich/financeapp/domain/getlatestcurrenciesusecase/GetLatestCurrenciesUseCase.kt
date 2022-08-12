package com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase

import com.antonharbatovich.financeapp.data.ExchangeRatesResponse
import com.antonharbatovich.financeapp.domain.entity.Result
import kotlinx.coroutines.flow.Flow

interface GetLatestCurrenciesUseCase {
    suspend operator fun invoke():Flow<Result<ExchangeRatesResponse>>
}
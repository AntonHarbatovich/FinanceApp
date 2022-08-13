package com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb
import com.antonharbatovich.financeapp.domain.entity.Result
import kotlinx.coroutines.flow.Flow

interface GetLatestCurrenciesUseCase {
    suspend operator fun invoke(base:String):Flow<Result<List<CurrencyDb>>>
}
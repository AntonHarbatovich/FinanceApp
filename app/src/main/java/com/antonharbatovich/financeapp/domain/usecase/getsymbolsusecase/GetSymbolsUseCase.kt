package com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase

import com.antonharbatovich.financeapp.domain.entity.Result
import kotlinx.coroutines.flow.Flow

interface GetSymbolsUseCase {
    suspend operator fun invoke(): Flow<Result<List<String>>>
}
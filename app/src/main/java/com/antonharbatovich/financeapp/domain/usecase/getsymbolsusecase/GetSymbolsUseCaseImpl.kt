package com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase

import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSymbolsUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository
) : GetSymbolsUseCase {
    override suspend fun invoke(): Flow<Result<List<String>>> = repository.getSymbols()
}
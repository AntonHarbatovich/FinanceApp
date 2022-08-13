package com.antonharbatovich.financeapp.domain.usecase.getlistdbcurrenciesusecase

import com.antonharbatovich.financeapp.domain.entity.Currency

interface GetListCurrenciesDbUseCase {
    suspend operator fun invoke(base: String): List<Currency>
}
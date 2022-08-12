package com.antonharbatovich.financeapp.domain.usecase.sortorderusecase

import com.antonharbatovich.financeapp.data.Currency

interface SortOrderUseCase {
    suspend operator fun invoke(
        value: String,
        listCurrencies: List<Currency>
    ): List<Currency>
}
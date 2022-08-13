package com.antonharbatovich.financeapp.domain.usecase.sortorderusecase

import com.antonharbatovich.financeapp.domain.entity.Currency

class SortOrderUseCaseImpl : SortOrderUseCase {

    override suspend fun invoke(value: String, listCurrencies: List<Currency>): List<Currency> {
        var list = listOf<Currency>()
        when (value) {
            alphabetically_ascending_order -> {
                list = listCurrencies.sortedBy { currency ->
                    currency.currencyDb.symbol
                }
            }
            alphabetically_descending_order -> {
                list = listCurrencies.sortedBy { currency ->
                    currency.currencyDb.symbol
                }.reversed()
            }
            value_ascending_order -> {
                list = listCurrencies.sortedBy { currency ->
                    currency.currencyDb.value
                }
            }
            value_descending_order -> {
                list = listCurrencies.sortedBy { currency ->
                    currency.currencyDb.value
                }.reversed()
            }
        }
        return list
    }

    companion object {
        const val alphabetically_ascending_order = "alphabetically_ascending_order"
        const val alphabetically_descending_order = "alphabetically_descending_order"
        const val value_ascending_order = "value_ascending_order"
        const val value_descending_order = "value_descending_order"
    }
}
package com.antonharbatovich.financeapp.domain.usecase.getlistdbcurrenciesusecase

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

interface GetListCurrenciesDbUseCase {
    suspend operator fun invoke(base:String): List<CurrencyDb>
}
package com.antonharbatovich.financeapp.domain.entity

import com.antonharbatovich.financeapp.data.db.entity.CurrencyDb

data class Currency(
    val currencyDb: CurrencyDb,
    var checkable: Boolean
)

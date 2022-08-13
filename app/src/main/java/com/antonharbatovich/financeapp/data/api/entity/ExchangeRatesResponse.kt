package com.antonharbatovich.financeapp.data

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class ExchangeRatesResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Map<String,String>,
    @SerializedName("success")
    val success: Boolean
)

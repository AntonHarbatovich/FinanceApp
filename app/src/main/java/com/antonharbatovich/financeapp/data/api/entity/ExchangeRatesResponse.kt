package com.antonharbatovich.financeapp.data

import com.google.gson.annotations.SerializedName

data class ExchangeRatesResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Map<String,Double>,
    @SerializedName("success")
    val success: Boolean
)

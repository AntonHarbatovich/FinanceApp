package com.antonharbatovich.financeapp.data.api.entity

data class SymbolsResponse(
    val success: Boolean,
    val symbols: Map<String, String>
)

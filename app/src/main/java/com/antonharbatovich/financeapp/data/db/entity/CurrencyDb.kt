package com.antonharbatovich.financeapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyDb(
    val baseCurrency:String,
    @PrimaryKey
    val symbol: String,
    val value: String
)
package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.data.api.ExchangeRatesService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideExchangeRatesService() = ExchangeRatesService()
}
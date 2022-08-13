package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.data.api.ExchangeRatesService
import com.antonharbatovich.financeapp.data.db.dao.CurrenciesDao
import com.antonharbatovich.financeapp.data.repository.DataBaseSourceImpl
import com.antonharbatovich.financeapp.data.repository.RemoteRepositoryImpl
import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRemoteRepository(service: ExchangeRatesService): RemoteRepository {
        return RemoteRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideDataBaseSource(currenciesDao: CurrenciesDao): DataBaseSource {
        return DataBaseSourceImpl(currenciesDao)
    }
}
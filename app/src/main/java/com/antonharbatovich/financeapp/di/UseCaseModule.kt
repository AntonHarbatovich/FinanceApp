package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCaseImpl
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetLatestCurrenciesUseCase(repository: RemoteRepository): GetLatestCurrenciesUseCase {
        return GetLatestCurrenciesUseCaseImpl(repository)
    }
}

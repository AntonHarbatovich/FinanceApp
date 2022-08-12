package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase.GetLatestCurrenciesUseCaseImpl
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCase
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCaseImpl
import com.antonharbatovich.financeapp.domain.usecase.sortorderusecase.SortOrderUseCase
import com.antonharbatovich.financeapp.domain.usecase.sortorderusecase.SortOrderUseCaseImpl
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

    @Provides
    @Singleton
    fun provideSortOrderUseCase(): SortOrderUseCase {
        return SortOrderUseCaseImpl()
    }

    @Provides
    @Singleton
    fun provideGetSymbols(repository: RemoteRepository): GetSymbolsUseCase {
        return GetSymbolsUseCaseImpl(repository)
    }
}

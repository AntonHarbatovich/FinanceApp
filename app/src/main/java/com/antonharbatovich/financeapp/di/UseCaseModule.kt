package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCaseImpl
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import com.antonharbatovich.financeapp.domain.sortorderusecase.SortOrderUseCase
import com.antonharbatovich.financeapp.domain.sortorderusecase.SortOrderUseCaseImpl
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
}

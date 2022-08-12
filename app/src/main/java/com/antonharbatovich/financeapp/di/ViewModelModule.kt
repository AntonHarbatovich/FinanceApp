package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCase
import com.antonharbatovich.financeapp.domain.usecase.sortorderusecase.SortOrderUseCase
import com.antonharbatovich.financeapp.presentation.base.BaseViewModel
import com.antonharbatovich.financeapp.presentation.viewmodel.PopularViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun providesPopularViewModel(
        getLatestCurrenciesUseCase: GetLatestCurrenciesUseCase,
        sortedOrderUseCase: SortOrderUseCase,
        getSymbolsUseCase: GetSymbolsUseCase
    ): PopularViewModel {
        return PopularViewModel(getLatestCurrenciesUseCase, sortedOrderUseCase,getSymbolsUseCase)
    }
}
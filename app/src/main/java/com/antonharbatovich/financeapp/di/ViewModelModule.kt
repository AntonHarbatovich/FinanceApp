package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.sortorderusecase.SortOrderUseCase
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
        sortedOrderUseCase: SortOrderUseCase
    ): PopularViewModel {
        return PopularViewModel(getLatestCurrenciesUseCase, sortedOrderUseCase)
    }
}
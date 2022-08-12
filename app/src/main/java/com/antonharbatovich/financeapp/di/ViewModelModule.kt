package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.presentation.base.BaseViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun providesBaseViewModel(getLatestCurrenciesUseCase: GetLatestCurrenciesUseCase): BaseViewModel {
        return BaseViewModel(getLatestCurrenciesUseCase)
    }
}
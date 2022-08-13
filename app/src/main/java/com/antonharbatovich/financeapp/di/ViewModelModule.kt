package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.usecase.checklatestcurrenciesusecase.CheckLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.deletedbcurrencyusecase.DeleteDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCase
import com.antonharbatovich.financeapp.domain.usecase.insertdbcurrencyusecase.InsertDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.sortorderusecase.SortOrderUseCase
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
        checkLatestCurrenciesUseCase: CheckLatestCurrenciesUseCase,
        sortedOrderUseCase: SortOrderUseCase,
        getSymbolsUseCase: GetSymbolsUseCase,
        insertDbCurrencyUseCase: InsertDbCurrencyUseCase,
        deleteDbCurrencyUseCase: DeleteDbCurrencyUseCase
    ): PopularViewModel {
        return PopularViewModel(
            getLatestCurrenciesUseCase,
            checkLatestCurrenciesUseCase,
            sortedOrderUseCase,
            getSymbolsUseCase,
            insertDbCurrencyUseCase,
            deleteDbCurrencyUseCase
        )
    }
}
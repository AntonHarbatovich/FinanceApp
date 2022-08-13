package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.domain.repository.DataBaseSource
import com.antonharbatovich.financeapp.domain.repository.RemoteRepository
import com.antonharbatovich.financeapp.domain.usecase.checklatestcurrenciesusecase.CheckLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.checklatestcurrenciesusecase.CheckLatestCurrenciesUseCaseImpl
import com.antonharbatovich.financeapp.domain.usecase.deletedbcurrencyusecase.DeleteDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.deletedbcurrencyusecase.DeleteDbCurrencyUseCaseImpl
import com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase.GetLatestCurrenciesUseCaseImpl
import com.antonharbatovich.financeapp.domain.usecase.getlistdbcurrenciesusecase.GetListCurrenciesDbUseCase
import com.antonharbatovich.financeapp.domain.usecase.getlistdbcurrenciesusecase.GetListCurrenciesDbUseCaseImpl
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCase
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCaseImpl
import com.antonharbatovich.financeapp.domain.usecase.insertdbcurrencyusecase.InsertDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.insertdbcurrencyusecase.InsertDbCurrencyUseCaseImpl
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

    @Provides
    @Singleton
    fun provideGetListCurrenciesDbUseCase(dataBaseSource: DataBaseSource): GetListCurrenciesDbUseCase {
        return GetListCurrenciesDbUseCaseImpl(dataBaseSource)
    }

    @Provides
    @Singleton
    fun provideInsertDbCurrencyUseCase(dataBaseSource: DataBaseSource): InsertDbCurrencyUseCase {
        return InsertDbCurrencyUseCaseImpl(dataBaseSource)
    }

    @Provides
    @Singleton
    fun provideDeleteDbCurrencyUseCase(dataBaseSource: DataBaseSource): DeleteDbCurrencyUseCase {
        return DeleteDbCurrencyUseCaseImpl(dataBaseSource)
    }

    @Provides
    @Singleton
    fun provideCheckLatestCurrenciesUseCase(dataBaseSource: DataBaseSource): CheckLatestCurrenciesUseCase {
        return CheckLatestCurrenciesUseCaseImpl(dataBaseSource)
    }
}

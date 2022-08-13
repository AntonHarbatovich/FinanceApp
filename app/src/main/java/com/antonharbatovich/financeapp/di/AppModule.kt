package com.antonharbatovich.financeapp.di

import android.app.Application
import android.content.Context
import com.antonharbatovich.financeapp.data.db.DataBase
import com.antonharbatovich.financeapp.data.db.dao.CurrenciesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideCurrenciesDao(dataBase: DataBase): CurrenciesDao {
        return dataBase.currenciesDao()
    }

    @Provides
    @Singleton
    fun provideRoomDbInstance(): DataBase {
        return DataBase.getDataBaseInstance(provideAppContext())
    }

    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return application.applicationContext
    }
}
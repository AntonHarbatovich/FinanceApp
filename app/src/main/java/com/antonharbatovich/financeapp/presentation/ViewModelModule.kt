package com.antonharbatovich.financeapp.presentation

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun providesBaseViewModel():BaseViewModel{
        return BaseViewModel()
    }
}
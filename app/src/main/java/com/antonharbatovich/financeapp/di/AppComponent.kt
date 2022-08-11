package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.MainActivity
import com.antonharbatovich.financeapp.presentation.BaseFragment
import com.antonharbatovich.financeapp.presentation.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ViewModelModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: BaseFragment)
}
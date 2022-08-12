package com.antonharbatovich.financeapp.di

import com.antonharbatovich.financeapp.presentation.activity.MainActivity
import com.antonharbatovich.financeapp.presentation.base.BaseFragment
import com.antonharbatovich.financeapp.presentation.fragment.PopularFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ViewModelModule::class, ApiModule::class, RepositoryModule::class, UseCaseModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: PopularFragment)
}
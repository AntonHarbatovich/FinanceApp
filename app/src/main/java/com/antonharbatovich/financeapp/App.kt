package com.antonharbatovich.financeapp

import android.app.Application
import com.antonharbatovich.financeapp.di.AppComponent
import com.antonharbatovich.financeapp.di.AppModule
import com.antonharbatovich.financeapp.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
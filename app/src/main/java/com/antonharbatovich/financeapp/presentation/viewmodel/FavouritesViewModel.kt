package com.antonharbatovich.financeapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.antonharbatovich.financeapp.domain.entity.Currency
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.entity.UIState
import com.antonharbatovich.financeapp.domain.usecase.deletedbcurrencyusecase.DeleteDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.getlistdbcurrenciesusecase.GetListCurrenciesDbUseCase
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCase
import com.antonharbatovich.financeapp.domain.usecase.insertdbcurrencyusecase.InsertDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.sortorderusecase.SortOrderUseCase
import com.antonharbatovich.financeapp.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val getListCurrenciesDbUseCase: GetListCurrenciesDbUseCase,
    private val getSymbolsUseCase: GetSymbolsUseCase,
    private val sortOrderUseCase: SortOrderUseCase,
    private val insertDbCurrencyUseCase:InsertDbCurrencyUseCase,
    private val deleteDbCurrencyUseCase: DeleteDbCurrencyUseCase
) : BaseViewModel() {



     fun getListCurrenciesDb() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                listCurrencies = getListCurrenciesDbUseCase(baseCurrency)
                setUiState(UIState.Success(listCurrencies))
            }
        }
    }

    fun getSymbols() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getSymbolsUseCase().collect { result ->
                    when (result) {
                        is Result.Success -> {
                            result.data?.let { data ->
                                listSymbols = data
                            }
                        }
                        is Result.Error -> {
                            result.message?.let { message ->
                                setUiState(UIState.Error(message))
                            }
                        }
                        is Result.UnknownError -> UIState.UnknownError
                        else -> {}
                    }
                }
            }
        }
    }

    fun changeBaseCurrency(base: String) {
        baseCurrency = base
        getListCurrenciesDb()
    }

    fun sortOrder(value: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                listCurrencies = sortOrderUseCase.invoke(value, listCurrencies)
                setUiState(UIState.SortedOrder(listCurrencies))
            }
        }
    }

    fun onStarClicked(currency: Currency) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (currency.checkable) {
                    insertDbCurrencyUseCase(currency.currencyDb)
                    Log.e("PopularViewModel","insertDbCurrencyUseCase")
                } else {
                    deleteDbCurrencyUseCase(currency.currencyDb)
                    Log.e("PopularViewModel","deleteDbCurrencyUseCase")
                }
            }
        }
    }
}
package com.antonharbatovich.financeapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.antonharbatovich.financeapp.domain.entity.Currency
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.entity.UIState
import com.antonharbatovich.financeapp.domain.usecase.checklatestcurrenciesusecase.CheckLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.deletedbcurrencyusecase.DeleteDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.domain.usecase.getsymbolsusecase.GetSymbolsUseCase
import com.antonharbatovich.financeapp.domain.usecase.insertdbcurrencyusecase.InsertDbCurrencyUseCase
import com.antonharbatovich.financeapp.domain.usecase.sortorderusecase.SortOrderUseCase
import com.antonharbatovich.financeapp.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularViewModel @Inject constructor(
    private val getLatestCurrenciesUseCase: GetLatestCurrenciesUseCase,
    private val checkLatestCurrenciesUseCase: CheckLatestCurrenciesUseCase,
    private val sortOrderUseCase: SortOrderUseCase,
    private val getSymbolsUseCase: GetSymbolsUseCase,
    private val insertDbCurrencyUseCase: InsertDbCurrencyUseCase,
    private val deleteDbCurrencyUseCase: DeleteDbCurrencyUseCase
) : BaseViewModel() {

    init {
        getLatestCurrencies(baseCurrency)
        getSymbols()
    }

    private fun getLatestCurrencies(baseCurrency: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getLatestCurrenciesUseCase(baseCurrency).collect { result ->
                    when (result) {
                        is Result.Loading -> setUiState(UIState.Loading)
                        is Result.Success -> {
                            result.data?.let { data ->
                                listCurrencies = checkLatestCurrenciesUseCase(data)
                                setUiState(UIState.Success(listCurrencies))
                            }
                        }
                        is Result.Error -> {
                            result.message?.let { message ->
                                setUiState(UIState.Error(message))
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getSymbols() {
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
                        else -> {}
                    }
                }
            }
        }
    }

    fun changeBaseCurrency(base: String) {
        baseCurrency = base
        getLatestCurrencies(baseCurrency)
    }

    fun sortOrder(value: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                listCurrencies = sortOrderUseCase.invoke(value, listCurrencies)
                setUiState(UIState.SortedOrder(listCurrencies))
            }
        }
    }

    fun setListSymbols(): List<String> {
        return listSymbols
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
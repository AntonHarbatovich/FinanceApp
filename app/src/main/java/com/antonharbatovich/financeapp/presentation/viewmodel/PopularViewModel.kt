package com.antonharbatovich.financeapp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.entity.UIState
import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import com.antonharbatovich.financeapp.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularViewModel @Inject constructor(
    private val getLatestCurrenciesUseCase: GetLatestCurrenciesUseCase
) : BaseViewModel() {
    var baseCurrency = BASE

    init {
        getLatestCurrencies(baseCurrency)
    }

    private fun getLatestCurrencies(baseCurrency: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getLatestCurrenciesUseCase(baseCurrency).collect { result ->
                    when (result) {
                        is Result.Loading -> setUiState(UIState.Loading)
                        is Result.Success -> {
                            result.data?.let { data ->
                                setUiState(UIState.Success(data))
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

    fun changeBaseCurrency(base: String) {
        baseCurrency = base
        getLatestCurrencies(baseCurrency)
    }

    companion object {
        const val BASE = "USD"
    }
}
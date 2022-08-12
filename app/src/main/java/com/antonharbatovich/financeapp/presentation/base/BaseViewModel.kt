package com.antonharbatovich.financeapp.presentation.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonharbatovich.financeapp.data.ExchangeRatesResponse
import com.antonharbatovich.financeapp.domain.entity.Result
import com.antonharbatovich.financeapp.domain.getlatestcurrenciesusecase.GetLatestCurrenciesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BaseViewModel @Inject constructor(
    private val getLatestCurrenciesUseCase: GetLatestCurrenciesUseCase
) : ViewModel() {

    private var response:ExchangeRatesResponse? = null

    fun getLatestCurrencies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getLatestCurrenciesUseCase().collect { result ->
                    when (result) {
                        is Result.Loading -> {}
                        is Result.Success -> {
                            result.data?.let {
                                response = it
                            }
                            Log.e("BaseViewModel", "${result.data}")
                        }
                        is Result.Error -> {}
                    }
                }
            }
        }
    }

}
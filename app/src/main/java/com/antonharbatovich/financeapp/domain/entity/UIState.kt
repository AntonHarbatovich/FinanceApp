package com.antonharbatovich.financeapp.domain.entity

import com.antonharbatovich.financeapp.data.Currency

sealed class UIState {
    object Loading : UIState()
    class Success(val data:List<Currency>):UIState()
    class Error(val message:String):UIState()
    class SortedOrder(val data:List<Currency>):UIState()
}
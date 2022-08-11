package com.antonharbatovich.financeapp.domain

sealed class UIStateBase {
    object Loading : UIStateBase()
}
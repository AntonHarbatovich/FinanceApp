package com.antonharbatovich.financeapp.domain.entity

sealed class UIStateBase {
    object Loading : UIStateBase()
}
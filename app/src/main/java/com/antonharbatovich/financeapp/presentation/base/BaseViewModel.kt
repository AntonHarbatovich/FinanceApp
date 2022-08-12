package com.antonharbatovich.financeapp.presentation.base

import androidx.lifecycle.ViewModel
import com.antonharbatovich.financeapp.domain.entity.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState: StateFlow<UIState> = _uiState

    fun setUiState(value: UIState) {
        _uiState.value = value
    }

}
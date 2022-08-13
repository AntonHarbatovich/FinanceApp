package com.antonharbatovich.financeapp.presentation.fragment

import androidx.lifecycle.lifecycleScope
import com.antonharbatovich.financeapp.App
import com.antonharbatovich.financeapp.domain.entity.Currency
import com.antonharbatovich.financeapp.domain.entity.UIState
import com.antonharbatovich.financeapp.presentation.base.BaseFragment
import com.antonharbatovich.financeapp.presentation.viewmodel.PopularViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularFragment : BaseFragment() {
    @Inject
    lateinit var popularViewModel: PopularViewModel
    override fun setupOnViewCreated() {
        observeUISate()
    }

    override fun setupOnCreateView() {
        App.appComponent.inject(this)
        popularViewModel.getLatestCurrencies()
        popularViewModel.getSymbols()
        setTextCurrency(popularViewModel.baseCurrency)
    }

    override fun changeBaseCurrency(base: String) {
        popularViewModel.changeBaseCurrency(base)
    }

    override fun setOrder(selectValue: String) {
        popularViewModel.sortOrder(selectValue)
    }

    override fun setListSymbols(): List<String> = popularViewModel.setListSymbols()

    override fun onStarClickListener(currency: Currency) {
        popularViewModel.onStarClicked(currency)
    }

    private fun observeUISate() {
        viewLifecycleOwner.lifecycleScope.launch {
            popularViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UIState.Loading -> startLoadingIndicator()
                    is UIState.Success -> {
                        stopLoadingIndicator()
                        setCurrencies(uiState.data)
                    }
                    is UIState.Error -> {
                        Snackbar.make(requireView(), uiState.message, Snackbar.LENGTH_LONG).show()
                    }
                    is UIState.SortedOrder -> {
                        setCurrencies(uiState.data)
                    }
                }
            }
        }
    }
}
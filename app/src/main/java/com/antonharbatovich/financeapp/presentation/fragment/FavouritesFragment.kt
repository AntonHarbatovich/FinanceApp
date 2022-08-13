package com.antonharbatovich.financeapp.presentation.fragment

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.antonharbatovich.financeapp.App
import com.antonharbatovich.financeapp.R
import com.antonharbatovich.financeapp.domain.entity.Currency
import com.antonharbatovich.financeapp.domain.entity.UIState
import com.antonharbatovich.financeapp.presentation.base.BaseFragment
import com.antonharbatovich.financeapp.presentation.viewmodel.FavouritesViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouritesFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: FavouritesViewModel

    override fun setupOnViewCreated() {
        observeUISate()
    }

    override fun setupOnCreateView() {
        App.appComponent.inject(this)
        viewModel.getListCurrenciesDb()
        viewModel.getSymbols()
        setTextCurrency(viewModel.baseCurrency)
    }

    override fun changeBaseCurrency(base: String) {
        viewModel.changeBaseCurrency(base)
    }

    override fun setOrder(selectValue: String) {
        viewModel.sortOrder(selectValue)
    }

    override fun setListSymbols(): List<String> = viewModel.setListSymbols()

    override fun onStarClickListener(currency: Currency) {
        viewModel.onStarClicked(currency)
    }

    private fun observeUISate() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UIState.Loading -> startLoadingIndicator()
                    is UIState.Success -> {
                        stopLoadingIndicator()
                        setCurrencies(uiState.data)
                    }
                    is UIState.Error -> {
                        Toast.makeText(requireActivity(), uiState.message, Toast.LENGTH_LONG).show()
                    }
                    is UIState.SortedOrder -> {
                        setCurrencies(uiState.data)
                    }
                    is UIState.UnknownError -> {
                        Toast.makeText(
                            requireActivity(),
                            getString(R.string.description_error_unknown),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}
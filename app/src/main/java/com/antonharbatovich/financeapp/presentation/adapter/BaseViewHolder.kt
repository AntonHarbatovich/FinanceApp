package com.antonharbatovich.financeapp.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.antonharbatovich.financeapp.databinding.ItemCurrencyBinding
import com.antonharbatovich.financeapp.domain.entity.Currency

class BaseViewHolder(
    private val binding: ItemCurrencyBinding,
    private val onStarClickListener: (currency: Currency) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(currency: Currency) {
        binding.itemCurrencyName.text = currency.currencyDb.symbol
        binding.itemCurrencyValue.text = currency.currencyDb.value
        binding.itemCurrencyRadioButton.apply {
            isChecked = currency.checkable
            setOnClickListener {
                currency.checkable = !currency.checkable
                isChecked = currency.checkable
                onStarClickListener(currency)
            }
        }
    }
}
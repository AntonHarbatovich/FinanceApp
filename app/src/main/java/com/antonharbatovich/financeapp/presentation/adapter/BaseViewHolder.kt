package com.antonharbatovich.financeapp.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.antonharbatovich.financeapp.data.Currency
import com.antonharbatovich.financeapp.databinding.ItemCurrencyBinding

class BaseViewHolder(
    private val binding: ItemCurrencyBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(currency: Currency){
        binding.itemCurrencyName.text = currency.symbol
        binding.itemCurrencyValue.text = currency.value.toString()
    }
}
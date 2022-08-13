package com.antonharbatovich.financeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antonharbatovich.financeapp.databinding.ItemCurrencyBinding
import com.antonharbatovich.financeapp.domain.entity.Currency

class BaseAdapter(
    private val onStarClickListener: (currency: Currency) -> Unit
) : RecyclerView.Adapter<BaseViewHolder>() {
    private var currencies: List<Currency> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding =
            ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseViewHolder(binding, onStarClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int = currencies.size
    fun setData(list: List<Currency>) {
        currencies = list
        notifyDataSetChanged()
    }


}
package com.antonharbatovich.financeapp.presentation.base

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.antonharbatovich.financeapp.R
import com.antonharbatovich.financeapp.data.Currency
import com.antonharbatovich.financeapp.databinding.BaseFragmentBinding
import com.antonharbatovich.financeapp.presentation.adapter.BaseAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

abstract class BaseFragment : Fragment() {

    private var _binding: BaseFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = BaseAdapter()
    private lateinit var currencyName: String
    private var itemDialogIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BaseFragmentBinding.inflate(inflater, container, false)
        setupOnCreateView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setIconMenu()
        setupOnViewCreated()
        setOnClickListener()
        currencyName = view.context.getString(R.string.currency_name_usd)
    }

    private fun setOnClickListener() {
        binding.baseFragmentToolbarButtonSort.setOnClickListener {
            openSortDialogFragment()
        }
    }

    private fun setIconMenu() {
        binding.baseFragmentToolbarMenuCurrency.setOnClickListener {
            val popupWrapper = ContextThemeWrapper(requireActivity(), R.style.PopupMenu)
            val popupMenu = PopupMenu(popupWrapper, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.usd -> {
                        setCurrencyName(R.string.currency_name_usd)
                        changeBaseCurrency(currencyName)
                        true
                    }
                    R.id.eur -> {
                        setCurrencyName(R.string.currency_name_eur)
                        changeBaseCurrency(currencyName)
                        true
                    }
                    R.id.rub -> {
                        setCurrencyName(R.string.currency_name_rub)
                        changeBaseCurrency(currencyName)
                        true
                    }
                    R.id.byn -> {
                        setCurrencyName(R.string.currency_name_byn)
                        changeBaseCurrency(currencyName)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_currency)
            popupMenu.show()
        }
    }

    private fun setCurrencyName(currency: Int) {
        currencyName = requireActivity().getString(currency)
        setTextCurrency(currencyName)
    }

    abstract fun setupOnViewCreated()
    abstract fun setupOnCreateView()
    abstract fun changeBaseCurrency(base: String)
    abstract fun setOrder(selectValue: String)

    private fun openSortDialogFragment() {

        val itemsTitle = resources.getStringArray(R.array.sorted_name)
        val itemsValue = resources.getStringArray(R.array.sorted_value)
        var selectValue: String = itemsValue[itemDialogIndex]
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(getString(R.string.title_sort))
            .setSingleChoiceItems(itemsTitle, itemDialogIndex) { dialog, which ->
                itemDialogIndex = which
                selectValue = itemsValue[which]
            }
            .setPositiveButton(getString(R.string.title_button_ok)) { dialog, which ->
                setOrder(selectValue)
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.title_button_cancel)) { dialog, which ->
                dialog.cancel()
            }.show()
    }

    fun setTextCurrency(text: String) {
        binding.baseFragmentToolbarCurrencyName.text = text
    }

    private fun setAdapter() {
        binding.baseFragmentRecyclerView.adapter = adapter
    }

    fun setCurrencies(data: List<Currency>) {
        adapter.setData(data)
    }

    fun startLoadingIndicator() {
        binding.fragmentMainLoadingStateIndicator.visibility = View.VISIBLE
    }

    fun stopLoadingIndicator() {
        binding.fragmentMainLoadingStateIndicator.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
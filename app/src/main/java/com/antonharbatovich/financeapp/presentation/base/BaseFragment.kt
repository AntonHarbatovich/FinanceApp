package com.antonharbatovich.financeapp.presentation.base

import android.os.Bundle
import android.view.*
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
        setTextCurrency(view.context.getString(R.string.currency_name_usd))
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
            val listSymbols = setListSymbols()

            for (i in listSymbols.indices) {
                popupMenu.menu.add(i, Menu.FIRST, i, listSymbols[i])
            }
                popupMenu.setOnMenuItemClickListener { item ->
                    setCurrencyName(item.title.toString())
                    changeBaseCurrency(item.title.toString())
                    false
                }
            popupMenu.show()
        }
    }

    private fun setCurrencyName(currency: String) {
        setTextCurrency(currency)
    }

    abstract fun setupOnViewCreated()
    abstract fun setupOnCreateView()
    abstract fun changeBaseCurrency(base: String)
    abstract fun setOrder(selectValue: String)
    abstract fun setListSymbols(): List<String>

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

    private fun setTextCurrency(text: String) {
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
package com.antonharbatovich.financeapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antonharbatovich.financeapp.App
import com.antonharbatovich.financeapp.databinding.BaseFragmentBinding
import javax.inject.Inject

class BaseFragment : Fragment() {
    private var _binding: BaseFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BaseFragmentBinding.inflate(inflater, container, false)
        App.appComponent.inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLatestCurrencies()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
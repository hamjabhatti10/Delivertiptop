package com.hamza.delivertiptop.ui.fragments.salesSummaryFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.databinding.FragmentSalesSummaryBinding
import com.hamza.delivertiptop.ui.base.BaseFragment

class SalesSummaryFragment : BaseFragment() {

    private lateinit var mBinding: FragmentSalesSummaryBinding
    private lateinit var viewModel: SalesSummaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentSalesSummaryBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SalesSummaryViewModel::class.java)
    }

}
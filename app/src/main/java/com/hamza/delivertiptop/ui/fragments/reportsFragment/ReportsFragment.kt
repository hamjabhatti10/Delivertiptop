package com.hamza.delivertiptop.ui.fragments.reportsFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.databinding.FragmentReportsBinding
import com.hamza.delivertiptop.ui.base.BaseFragment
import com.hamza.delivertiptop.ui.fragments.fragment.loginFragment.LoginFragment
import com.hamza.delivertiptop.ui.fragments.salesSummaryFragment.SalesSummaryFragment
import com.hamza.delivertiptop.utils.ActivityUtils

class ReportsFragment : BaseFragment() {

    private lateinit var mBinding: FragmentReportsBinding

    private lateinit var viewModel: ReportsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentReportsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReportsViewModel::class.java)
        setListeners()
    }

    private fun setListeners() {
        mBinding.textViewReports.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), LoginFragment::class.java.name)
        }
        mBinding.imageViewSalesSummary.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), SalesSummaryFragment::class.java.name)
        }
    }

}
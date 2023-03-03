package com.hamza.delivertiptop.ui.fragments.reportsFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentReportsBinding
import com.hamza.delivertiptop.ui.base.BaseFragment
import com.hamza.delivertiptop.ui.fragments.day1Fragment.Day1Fragment
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
        mBinding.imageViewChart.setOnClickListener {
            mBinding.textViewSale.visibility= View.VISIBLE
            getData()
        }

    }

    private fun getData() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 2f))
        entries.add(BarEntry(2f, 3f))
        entries.add(BarEntry(3f, 4f))
        entries.add(BarEntry(4f, 5f))
        entries.add(BarEntry(5f, 6f))

        val barDataSet = BarDataSet(entries, "values")
        val data = BarData(barDataSet)
        mBinding.barChart.setNoDataText("")
        mBinding.barChart.invalidate()
        mBinding.barChart.data = data
        barDataSet.setColors(ContextCompat.getColor(mBinding.barChart.context, R.color.colorAccent),
        )
        mBinding.barChart.animateY(5000)
    }

}
package com.hamza.delivertiptop.ui.fragments.reportsFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.tabs.TabLayout
import com.hamza.delivertiptop.R
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
        mBinding.imageViewChart.setOnClickListener {
            if (!mBinding.layoutNoDataFound.isVisible){
            getData()
            }
        }
        mBinding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            /**
             * Called when a tab enters the selected state.
             *
             * @param tab The tab that was selected
             */
            override fun onTabSelected(tab: TabLayout.Tab?) {
              when (tab?.position)
                      {
                  1->{
                     mBinding.layoutNoDataFound.visibility= View.VISIBLE
                      mBinding.layoutAllViews.visibility = View.GONE
                      mBinding.textViewSale.visibility= View.GONE
                  }
                  else->{
                      mBinding.layoutNoDataFound.visibility= View.GONE
                      mBinding.layoutAllViews.visibility = View.VISIBLE
                  }


              }
            }

            /**
             * Called when a tab exits the selected state.
             *
             * @param tab The tab that was unselected
             */
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            /**
             * Called when a tab that is already selected is chosen again by the user. Some applications may
             * use this action to return to the top level of a category.
             *
             * @param tab The tab that was reselected.
             */
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


    }

    private fun getData() {
        if (mBinding.barChart.data==null){
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
        mBinding.barChart.animateY(500)

        }
        mBinding.barChart.visibility= if (mBinding.barChart.isVisible) View.GONE else View.VISIBLE
        mBinding.textViewSale.visibility= if (mBinding.textViewSale.isVisible) View.GONE else View.VISIBLE

    }

}
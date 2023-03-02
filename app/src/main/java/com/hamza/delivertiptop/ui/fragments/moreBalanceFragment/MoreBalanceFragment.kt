package com.hamza.delivertiptop.ui.fragments.moreBalanceFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentMoreBalanceBinding
import com.hamza.delivertiptop.databinding.FragmentMoreBinding
import com.hamza.delivertiptop.ui.fragments.reportsFragment.ReportsFragment
import com.hamza.delivertiptop.utils.ActivityUtils

class MoreBalanceFragment : Fragment() {

    private lateinit var mBinding: FragmentMoreBalanceBinding
    private lateinit var viewModel: MoreBalanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentMoreBalanceBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MoreBalanceViewModel::class.java)
        setListeners()
    }

    private fun setListeners() {
        mBinding.textViewSales.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), ReportsFragment::class.java.name)
        }
    }

}
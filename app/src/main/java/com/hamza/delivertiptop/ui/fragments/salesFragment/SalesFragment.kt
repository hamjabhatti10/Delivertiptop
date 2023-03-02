package com.hamza.delivertiptop.ui.fragments.salesFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentSalesBinding
import com.hamza.delivertiptop.ui.base.BaseFragment

class SalesFragment : BaseFragment() {

    private lateinit var mBinding: FragmentSalesBinding
    private lateinit var viewModel: SalesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentSalesBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SalesViewModel::class.java)
    }

}
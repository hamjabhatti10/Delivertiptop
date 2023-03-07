package com.hamza.delivertiptop.ui.fragments.balanceFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentBalanceBinding
import com.hamza.delivertiptop.ui.base.BaseFragment
import com.hamza.delivertiptop.ui.fragments.transferFragment.TransferFragment
import com.hamza.delivertiptop.ui.fragments.verificationFragment.VerificationFragment
import com.hamza.delivertiptop.utils.ActivityUtils

class BalanceFragment : BaseFragment() {

   private lateinit var mBinding: FragmentBalanceBinding

    private lateinit var viewModel: BalanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding=FragmentBalanceBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BalanceViewModel::class.java)
        setListeners()
    }

    private fun setListeners() {
        mBinding.buttonTransferFunds.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), TransferFragment::class.java.name)
        }
        mBinding.buttonInstantTransfer.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), TransferFragment::class.java.name)
        }


    }
}
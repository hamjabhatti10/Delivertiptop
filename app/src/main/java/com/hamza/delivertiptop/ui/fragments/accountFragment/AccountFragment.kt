package com.hamza.delivertiptop.ui.fragments.accountFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hamza.delivertiptop.databinding.FragmentAccountBinding
import com.hamza.delivertiptop.ui.fragments.bankAccount.BankAccountFragment
import com.hamza.delivertiptop.ui.fragments.businessInformation.BusinessInformationFragment
import com.hamza.delivertiptop.ui.fragments.fragment.loginFragment.LoginFragment
import com.hamza.delivertiptop.ui.fragments.reportsFragment.ReportsFragment
import com.hamza.delivertiptop.ui.fragments.transferFragment.TransferFragment
import com.hamza.delivertiptop.utils.ActivityUtils

class AccountFragment : Fragment() {


    private lateinit var mBinding: FragmentAccountBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding= FragmentAccountBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        setListeners()
    }

    private fun setListeners() {
        mBinding.textViewBusinessInformation.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), BusinessInformationFragment::class.java.name)
        }
        mBinding.textViewTransfer.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), TransferFragment::class.java.name)
        }
        mBinding.textViewBankAccount.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), BankAccountFragment::class.java.name)
        }
    }

}
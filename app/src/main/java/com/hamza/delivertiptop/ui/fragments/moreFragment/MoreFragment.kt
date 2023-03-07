package com.hamza.delivertiptop.ui.fragments.moreFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hamza.delivertiptop.databinding.FragmentMoreBinding
import com.hamza.delivertiptop.ui.base.BaseFragment
import com.hamza.delivertiptop.ui.fragments.accountFragment.AccountFragment
import com.hamza.delivertiptop.ui.fragments.balanceFragment.BalanceFragment
import com.hamza.delivertiptop.ui.fragments.bankAccount.BankAccountFragment
import com.hamza.delivertiptop.ui.fragments.businessInformation.BusinessInformationFragment
import com.hamza.delivertiptop.ui.fragments.moreBalanceFragment.MoreBalanceFragment
import com.hamza.delivertiptop.ui.fragments.reportsFragment.ReportsFragment
import com.hamza.delivertiptop.ui.fragments.transferFragment.TransferFragment
import com.hamza.delivertiptop.utils.ActivityUtils

class MoreFragment : BaseFragment() {

    private lateinit var mBinding:FragmentMoreBinding
    private lateinit var viewModel: MoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentMoreBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MoreViewModel::class.java]
        setListeners()
    }

    private fun setListeners() {
        mBinding.textViewAccount.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), AccountFragment::class.java.name)
        }
        mBinding.textViewBalance.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), BalanceFragment::class.java.name)
        }
        mBinding.textViewReports.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), ReportsFragment::class.java.name)
        }
        mBinding.textViewBusinessInformation.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), BusinessInformationFragment::class.java.name)
        }
        mBinding.textViewTransfer.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), TransferFragment::class.java.name)
        }
        mBinding.textViewBankAccount.setOnClickListener {
            ActivityUtils.launchFragment(requireActivity(), BankAccountFragment::class.java.name)
        }
        mBinding.textViewItems.setOnClickListener {
            Toast.makeText(requireActivity(), "please contact to customer support to activate message " +
                    "info@deliverytiptop", Toast.LENGTH_SHORT).show()
        }
        mBinding.textViewCustomers.setOnClickListener {
            Toast.makeText(requireActivity(), "please contact to customer support to activate message " +
                    "info@deliverytiptop", Toast.LENGTH_SHORT).show()

        }
        mBinding.textViewOnlineCheckOut.setOnClickListener {
            Toast.makeText(requireActivity(), "please contact to customer support to activate message " +
                    "info@deliverytiptop", Toast.LENGTH_SHORT).show()

        }
        mBinding.textViewTeams.setOnClickListener {
            Toast.makeText(requireActivity(), "please contact to customer support to activate message " +
                    "info@deliverytiptop", Toast.LENGTH_SHORT).show()

        }
        mBinding.textViewAddOns.setOnClickListener {
            Toast.makeText(requireActivity(), "please contact to customer support to activate message " +
                    "info@deliverytiptop", Toast.LENGTH_SHORT).show()

        }
        mBinding.textViewRewardsAndReferrals.setOnClickListener {
            Toast.makeText(requireActivity(), "please contact to customer support to activate message " +
                    "info@deliverytiptop", Toast.LENGTH_SHORT).show()

        }
        mBinding.textViewSupport.setOnClickListener {
            Toast.makeText(requireActivity(), "please contact to customer support to activate message " +
                    "info@deliverytiptop", Toast.LENGTH_SHORT).show()

        }
    }

}
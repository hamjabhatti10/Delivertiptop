package com.hamza.delivertiptop.ui.fragments.verificationFragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentVerificationBinding
import com.hamza.delivertiptop.ui.activities.mainActivity.MainActivity
import com.hamza.delivertiptop.ui.base.BaseFragment
import com.hamza.delivertiptop.ui.fragments.reportsFragment.ReportsFragment
import com.hamza.delivertiptop.utils.ActivityUtils

class VerificationFragment : BaseFragment() {

    private lateinit var mBinding: FragmentVerificationBinding
    private lateinit var viewModel: VerificationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentVerificationBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[VerificationViewModel::class.java]
        setListeners()
    }

    private fun setListeners() {
        mBinding.buttonVerification.setOnClickListener {
            validation()
        }
    }

    private fun validation() {
        when {
            TextUtils.isEmpty(mBinding.editTextVerificationCode.text.toString()) -> {
                mBinding.editTextVerificationCode.error = "Verification Code Required"
            } else -> {
            activity.let {
                val intent = Intent(it, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

}
}
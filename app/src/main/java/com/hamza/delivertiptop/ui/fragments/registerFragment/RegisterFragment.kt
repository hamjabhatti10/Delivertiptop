package com.hamza.delivertiptop.ui.fragments.registerFragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentRegisterBinding
import com.hamza.delivertiptop.ui.base.BaseFragment

class RegisterFragment : BaseFragment() {

    private lateinit var mBinding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding= FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        validation()
    }

    private fun validation() {
        when {
            TextUtils.isEmpty(mBinding.editTextName.text.toString()) -> {
                mBinding.editTextName.error = "Name Required"
            }
            TextUtils.isEmpty(mBinding.editTextEmail.text.toString()) -> {
                mBinding.editTextName.error = "Email Required"
            }
            TextUtils.isEmpty(mBinding.editTextBusinessName.text.toString()) -> {
                mBinding.editTextBusinessName.error = "Business Required"
            }
            TextUtils.isEmpty(mBinding.editTextPhoneNumber.text.toString()) -> {
                mBinding.editTextPhoneNumber.error = "Phone Number Required"
            }
        }
    }

}
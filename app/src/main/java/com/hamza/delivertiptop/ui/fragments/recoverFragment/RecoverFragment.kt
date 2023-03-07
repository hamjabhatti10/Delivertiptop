package com.hamza.delivertiptop.ui.fragments.recoverFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentRecoverBinding
import com.hamza.delivertiptop.ui.base.BaseFragment

class RecoverFragment : BaseFragment() {

    private lateinit var mBinding: FragmentRecoverBinding
    private lateinit var viewModel: RecoverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentRecoverBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        mBinding.buttonRecover.setOnClickListener {
            validation()
        }

    }

    private fun validation() {
        when {
            TextUtils.isEmpty(mBinding.editTextEmail.text.toString()) -> {
                mBinding.editTextEmail.error = "Required Email"
            }
//            !Patterns.EMAIL_ADDRESS.matcher(mBinding.editTextEmail.text.toString()).matches() -> {
//                mBinding.editTextEmail.error = "Invalid Email"
//            }
            else ->{
                Toast.makeText(requireActivity(), "Password send to your Email", Toast.LENGTH_SHORT).show()
            }
        }

}}
package com.hamza.delivertiptop.ui.fragments.fragment.loginFragment


import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hamza.delivertiptop.databinding.FragmentLoginBinding
import com.hamza.delivertiptop.ui.base.BaseFragment
import com.hamza.delivertiptop.ui.fragments.verificationFragment.VerificationFragment
import com.hamza.delivertiptop.utils.ActivityUtils


class LoginFragment : BaseFragment() {
    private lateinit var mBinding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentLoginBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setListeners()
    }

    private fun setListeners() {

        mBinding.buttonSignIn.setOnClickListener {
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
            TextUtils.isEmpty(mBinding.editTextPassword.text.toString()) -> {
                mBinding.editTextPassword.error = "Required Password"
            }  else -> {
            ActivityUtils.launchFragment(requireActivity(), VerificationFragment::class.java.name)
        }
    }

}
}
package com.hamza.delivertiptop.ui.fragments.settingFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.FragmentSettingBinding
import com.hamza.delivertiptop.ui.base.BaseFragment

class SettingFragment : BaseFragment() {

   private lateinit var mBinding:FragmentSettingBinding

    private lateinit var viewModel: SettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding= FragmentSettingBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingViewModel::class.java)
    }

}
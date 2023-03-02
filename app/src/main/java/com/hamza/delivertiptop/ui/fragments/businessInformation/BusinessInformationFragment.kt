package com.hamza.delivertiptop.ui.fragments.businessInformation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R

class BusinessInformationFragment : Fragment() {

    companion object {
        fun newInstance() = BusinessInformationFragment()
    }

    private lateinit var viewModel: BusinessInformationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_business_information, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BusinessInformationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
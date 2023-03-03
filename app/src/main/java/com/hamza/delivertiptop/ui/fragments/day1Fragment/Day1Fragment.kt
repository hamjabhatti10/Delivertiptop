package com.hamza.delivertiptop.ui.fragments.day1Fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.ui.base.BaseFragment

class Day1Fragment : BaseFragment() {

    companion object {
        fun newInstance() = Day1Fragment()
    }

    private lateinit var viewModel: Day1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_day1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Day1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
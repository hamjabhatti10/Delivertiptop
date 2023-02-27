package com.hamza.delivertiptop.customData.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hamza.delivertiptop.BR
import com.hamza.delivertiptop.customData.interfaces.AdapterOnClick

class BaseViewHolder(private val mBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(mBinding.root) {

    fun bind(obj: Any?, callBack: AdapterOnClick) {
        mBinding.setVariable(BR.obj, obj)
        mBinding.setVariable(BR.click, callBack)
        mBinding.executePendingBindings()
    }
}
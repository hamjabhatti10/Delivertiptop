package com.hamza.delivertiptop.ui.base

import androidx.lifecycle.ViewModel
import com.hamza.delivertiptop.source.remote.rxjava.DisposableManager


abstract class BaseViewModel : ViewModel() {


    fun cancelServerRequest() {
        DisposableManager.dispose()
    }
}
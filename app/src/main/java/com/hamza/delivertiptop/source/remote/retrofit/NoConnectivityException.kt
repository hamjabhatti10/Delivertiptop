package com.hamza.delivertiptop.source.remote.retrofit

import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.application.DeliverTipTopApplication
import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = DeliverTipTopApplication.getContext().getString(R.string.noInternet)
}
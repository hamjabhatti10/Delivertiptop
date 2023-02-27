package com.hamza.delivertiptop.googleMapHelper

import android.content.Context
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.constant.Constants.DIRECTION_API
import com.hamza.delivertiptop.utils.Log

class Helper(var pContext: Context) {
    companion object {
        val MY_SOCKET_TIMEOUT_MS = 5000
        private lateinit var _Context: Context
    }

    init {
        _Context = pContext
    }

    fun getURL(clat: Double, clng: Double, dlat: Double, dlng: Double): String {
        Log.d(
            "Helper",
            "getURL: " + DIRECTION_API + clat + "," + clng + "&destination=" + dlat + "," + dlng + "&key=" + _Context.getString(
                R.string.google_maps_key
            )
        )
        return DIRECTION_API + clat + "," + clng + "&destination=" + dlat + "," + dlng + "&key=" + _Context.getString(
            R.string.google_maps_key
        )
    }


}

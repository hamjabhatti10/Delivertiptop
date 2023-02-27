package com.hamza.delivertiptop.source.local.prefrance

import android.content.Context
import android.content.SharedPreferences
import com.hamza.delivertiptop.application.DeliverTipTopApplication

object PrefUtils {
    private val PREF_NAME = "_Pref_"

    private fun getPreferences(): SharedPreferences {
        return DeliverTipTopApplication.getContext()
            .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun setBoolean(key: String, value: Boolean): Boolean {
        return getPreferences().edit().putBoolean(key, value).commit()
    }

    fun getBoolean(key: String): Boolean {
        return getPreferences().getBoolean(key, false)
    }

    fun getBooleanDefaultTrue(key: String): Boolean {
        return getPreferences().getBoolean(key, true)
    }

    fun setString(key: String, value: String?) {
        if (value != null && !value.isEmpty())
            getPreferences().edit().putString(key, value).apply()
    }

    fun clearStringData(key: String) {
        getPreferences().edit().putString(key, null).apply()
    }

    fun getString(key: String): String? {
        return getPreferences().getString(key, null)
    }

    fun setLong(key: String, value: Long) {
        getPreferences().edit().putLong(key, value).apply()
    }

    fun getLong(key: String): Long {
        return getPreferences().getLong(key, 0)
    }

    fun setInt(key: String, value: Int) {
        getPreferences().edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        return getPreferences().getInt(key, 0)
    }

    fun setFloat(key: String, value: Float) {
        getPreferences().edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String): Float {
        return getPreferences().getFloat(key, 0f)
    }


    fun removeValue(key: String) {
        getPreferences().edit().remove(key).apply()
    }

    fun clearAllPrefData() {
        getPreferences().edit().clear().apply()
    }
}

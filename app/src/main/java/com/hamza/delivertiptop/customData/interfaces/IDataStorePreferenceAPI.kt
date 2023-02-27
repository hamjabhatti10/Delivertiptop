package com.hamza.delivertiptop.customData.interfaces

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface IDataStorePreferenceAPI {
    fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T): Flow<T>
    fun <T> putPreference(key: Preferences.Key<T>, value: T)
    suspend fun <T> removePreference(key: Preferences.Key<T>)
    suspend fun clearAllPreference()
}
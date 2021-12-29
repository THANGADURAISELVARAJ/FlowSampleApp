package com.alvin.flowsample.db.preferenceDb

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.alvin.flowsample.db.constants.DbNames.PREFERENCE_DB_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

private val Context.preferencesDataStore: DataStore<Preferences> by preferencesDataStore(
    name = PREFERENCE_DB_NAME
)

class PrefStore @Inject constructor(@ApplicationContext val context: Context) {


    suspend fun <T> saveValue(keyName: Preferences.Key<T>, values: T) {
        context.preferencesDataStore.edit { preferences ->
            preferences[keyName] = values
        }
    }

    fun <T> getValue(keyName: Preferences.Key<T>): Flow<T?> {
        return context.preferencesDataStore.data
            .catch {
                if (it is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map { preferences ->
                preferences[keyName]
            }
    }
}
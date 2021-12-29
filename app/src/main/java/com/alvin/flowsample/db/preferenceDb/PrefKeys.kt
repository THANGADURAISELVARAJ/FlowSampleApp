package com.alvin.flowsample.db.preferenceDb

import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PrefKeys {

    val USER_FIRST_NAME = stringPreferencesKey("user_first_name")
    val USER_LAST_NAME = stringPreferencesKey("user_last_name")
    val USER_BIRTH_DAY = longPreferencesKey("user_birth_day")



}
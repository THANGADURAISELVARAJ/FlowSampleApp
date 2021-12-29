object LibraryDeps {
    /**
     * Android Core Dependencies
     * */
    private const val KOTLIN_CORE_KTX = "androidx.core:core-ktx:${Versions.VERSION_CORE_KTX}"
    private const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.VERSION_APP_COMPAT}"
    private const val MATERIAL_DESIGN =
        "com.google.android.material:material:${Versions.VERSION_MATERIAL}"
    private const val CONSTRAIN_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.VERSION_CONSTRAIN_LAYOUT}"

    val LIST_OF_ANDROID_CORE_LIBRARIES = arrayListOf<String>().apply {
        add(KOTLIN_CORE_KTX)
        add(APP_COMPAT)
        add(MATERIAL_DESIGN)
        add(CONSTRAIN_LAYOUT)
    }
}

object HiltDeps {
    /**
     * Hilt Dependencies
     * */
    const val HILT = "com.google.dagger:hilt-android:${Versions.VERSION_HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.VERSION_HILT}"
}

object LifeCycleDeps {
    /**
     * LifeCycle Dependencies
     * */
    const val LIFE_CYCLE_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VERSION_LIFE_CYCLE}"
    const val LIFE_CYCLE_LIVE_DATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.VERSION_LIFE_CYCLE}"
    const val LIFE_CYCLE_RUN_TIME =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.VERSION_LIFE_CYCLE}"
    const val LIFE_CYCLE_EXTENSIONS =
        "androidx.lifecycle:lifecycle-extensions:${Versions.VERSION_LIFE_CYCLE_EXTENSIONS}"
}

object KTXDeps {
    /**
     * Activity and fragment ktx
     * */
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.VERSION_ACTIVITY_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.VERSION_FRAGMENT_KTX}"
}

object CoilDeps {
    /**
     * Image Loading
     * */
    const val COIL = "io.coil-kt:coil:${Versions.VERSION_COIL}"
}

object WorkManagerDeps {
    /**
     * Work Manager
     * */
    const val WORK_MANAGER = "androidx.work:work-runtime-ktx:${Versions.VERSION_WORK_MANAGER}"
}

object RoomDeps {
    /**
     * Room Db
     * */
    const val ROOM = "androidx.room:room-runtime:${Versions.VERSION_ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.VERSION_ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.VERSION_ROOM}"
}

object RetrofitDeps {
    /**
     * Retrofit and Okhttp
     * */
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.VERSION_RETROFIT}"
    const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.VERSION_RETROFIT}"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.VERSION_OK_HTTP}"
}

object DataStoreDeps {
    /**
     * Data store
     * */
    const val DATA_STORE = "androidx.datastore:datastore-preferences:${Versions.VERSION_DATA_STORE}"
}


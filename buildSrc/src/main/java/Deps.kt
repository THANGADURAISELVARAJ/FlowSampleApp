object LibraryDeps {
    /**
     * Android Core Dependencies
     * */
    private const val KOTLIN_CORE_KTX = "androidx.core:core-ktx:${Versions.VERSION_CORE_KTX}"
    private const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.VERSION_APP_COMPAT}"
    private const val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.VERSION_MATERIAL}"
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
    const val LIFE_CYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VERSION_LIFE_CYCLE}"
    const val LIFE_CYCLE_LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.VERSION_LIFE_CYCLE}"
    const val LIFE_CYCLE_RUN_TIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.VERSION_LIFE_CYCLE}"
    const val LIFE_CYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.VERSION_LIFE_CYCLE_EXTENSIONS}"
}

object KTXDeps {
    /**
     * Activity and fragment ktx
     * */
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.VERSION_ACTIVITY_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.VERSION_FRAGMENT_KTX}"
}





object TestDeps {

    /**
     * Testing Dependencies
     * */
    private const val TEST_CORE_J_UNIT =
        "junit:junit:${Versions.VERSION_TEST_CORE_J_UNIT}"
    private const val TEST_ANDROID_J_UNIT =
        "androidx.test.ext:junit:${Versions.VERSION_TEST_ANDROID_J_UNIT}"
    private const val TEST_ANDROID_ESPRESSO =
        "androidx.test.espresso:espresso-core:${Versions.VERSION_TEST_ANDROID_ESPRESSO}"

    val LIST_OF_ANDROID_TEST_LIBRARIES = arrayListOf<String>().apply {
        add(TEST_ANDROID_J_UNIT)
        add(TEST_ANDROID_ESPRESSO)
    }

    val LIST_OF_TEST_LIBRARIES = arrayListOf<String>().apply {
        add(TEST_CORE_J_UNIT)
    }
}




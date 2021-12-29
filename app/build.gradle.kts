plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdk = AppConfigs.COMPILE_SDK

    defaultConfig {
        applicationId = AppConfigs.APPLICATION_ID
        minSdk = AppConfigs.MIN_SDK
        targetSdk = AppConfigs.TARGET_SDK
        versionCode = AppConfigs.VERSION_CODE
        versionName = AppConfigs.VERSION_NAME

        testInstrumentationRunner = AppConfigs.ANDROID_TEST_INSTRUMENTATION
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = AppConfigs.JVM_TARGET
    }

    buildFeatures {
        viewBinding = true
    }

    kapt {
        correctErrorTypes = true
    }

}

dependencies {

    /**
     * Core Dependencies
     * */
    implementation(LibraryDeps.LIST_OF_ANDROID_CORE_LIBRARIES)

    /**
     * Testing Dependencies
     * */
    testImplementation(TestDeps.LIST_OF_TEST_LIBRARIES)
    androidTestImplementation(TestDeps.LIST_OF_ANDROID_TEST_LIBRARIES)

    /**
     * Hilt Dependencies
     * */
    implementation(HiltDeps.HILT)
    kapt(HiltDeps.HILT_COMPILER)

    /**
     * Lifecycle Dependencies
     * */
    implementation(LifeCycleDeps.LIFE_CYCLE_VIEW_MODEL)
    implementation(LifeCycleDeps.LIFE_CYCLE_LIVE_DATA)
    implementation(LifeCycleDeps.LIFE_CYCLE_RUN_TIME)
    implementation(LifeCycleDeps.LIFE_CYCLE_EXTENSIONS)

    /**
     * KTX Dependencies
     * */
    implementation(KTXDeps.ACTIVITY_KTX)
    implementation(KTXDeps.FRAGMENT_KTX)

    /**
     * Image Loading
     * */
    implementation(CoilDeps.COIL)

    /**
     * Work Manager
     * */
    implementation(WorkManagerDeps.WORK_MANAGER)

    /**
     * Room
     * */
    implementation(RoomDeps.ROOM)
    kapt(RoomDeps.ROOM_COMPILER)
    implementation(RoomDeps.ROOM_KTX)

    /**
     * Retrofit
     * */
    implementation(RetrofitDeps.RETROFIT)
    implementation(RetrofitDeps.RETROFIT_GSON_CONVERTER)
    implementation(RetrofitDeps.OKHTTP_LOGGING_INTERCEPTOR)

    /**
     * Data store
     * */
    implementation(DataStoreDeps.DATA_STORE)

}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.VERSION_BUILD_TOOL}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.VERSION_KOTLIN}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.VERSION_HILT}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}
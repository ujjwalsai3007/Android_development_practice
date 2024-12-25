plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0") // Update version as needed
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0") // Match your Kotlin version
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

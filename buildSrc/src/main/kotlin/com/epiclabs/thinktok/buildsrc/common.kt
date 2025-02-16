package com.epiclabs.thinktok.buildsrc

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion.VERSION_21

internal fun TestedExtension.addCompileOptions() {
    compileOptions {
        sourceCompatibility = VERSION_21
        targetCompatibility = VERSION_21
    }
}

internal fun CommonExtension<*, *, *, *, *, *>.addBuildTypes() {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

internal fun TestedExtension.addDefaultConfig() {
    defaultConfig {
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

internal fun BaseAppModuleExtension.addBuildFeatures() {
    buildFeatures {
        compose = true
    }
}
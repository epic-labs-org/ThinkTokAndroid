import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId) 
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.epiclabs.thinktok"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.epiclabs.thinktok"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }

    ktlint {
        // Enable Android-specific linting rules
        android.set(true)
        // Fail the build if KtLint finds any issues
        ignoreFailures.set(true)
        verbose.set(true)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
        }

        reporters {
            reporter(ReporterType.PLAIN)
        }
    }
}

tasks.getByPath("preBuild").dependsOn("ktlintFormat")

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":feature:main:ui"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
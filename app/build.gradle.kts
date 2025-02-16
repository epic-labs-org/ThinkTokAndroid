import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    alias(libs.plugins.app.module)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.epiclabs.thinktok"

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
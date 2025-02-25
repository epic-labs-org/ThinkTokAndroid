plugins {
    alias(libs.plugins.android.module)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.epiclabs.thinktok.main.ui"
}

dependencies {
    implementation(project(":feature:main:presentation"))
    implementation(project(":core"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.compose)
    implementation(libs.koin.navigation)
    implementation(libs.koin.viewmodel)
    implementation(libs.koin.viewmodel.navigation)
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.junit4)

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
plugins {
    alias(libs.plugins.android.module)
}

android {
    namespace = "com.epiclabs.thinktok.core"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api(platform(libs.koin.bom))
    api(libs.koin.core)
}
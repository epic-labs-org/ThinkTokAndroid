plugins {
    alias(libs.plugins.android.module)
}

android {
    namespace = "com.epiclabs.thinktok.main.domain"
}

dependencies {
    implementation(project(":feature:main:domain:api"))
    implementation(libs.androidx.core.ktx)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.junit4)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.coroutines.android)
    testImplementation(libs.coroutines.test)
}
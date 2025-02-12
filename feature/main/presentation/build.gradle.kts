plugins {
    alias(libs.plugins.android.module)
}

android{
    namespace = "com.epiclabs.thinktok.main.presentation"
}

dependencies {
    implementation(project(":feature:main:domain"))
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
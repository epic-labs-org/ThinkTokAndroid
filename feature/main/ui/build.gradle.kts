plugins {
    alias(libs.plugins.android.module)
}

android{
    namespace = "com.epiclabs.thinktok.main.ui"
}

dependencies {
    implementation(project(":feature:main:presentation"))
    implementation(project(":core"))

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
plugins {
    alias(libs.plugins.android.module)
}

android {
    namespace = "com.epiclabs.thinktok.data.local"
}


dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}
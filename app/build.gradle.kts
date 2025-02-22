plugins {
    alias(libs.plugins.app.module)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp) apply false
}

android {
    namespace = "com.epiclabs.thinktok"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data:remote"))
    implementation(project(":data:local"))
    implementation(project(":feature:main:ui"))
    implementation(project(":feature:main:domain"))
    implementation(project(":feature:main:domain:api"))
    implementation(project(":feature:main:presentation"))
    implementation(project(":feature:main:repository"))
    implementation(project(":feature:main:repository:api"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
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

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
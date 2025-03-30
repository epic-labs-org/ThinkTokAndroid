plugins {
    alias(libs.plugins.android.module)
    id(libs.plugins.kotlin.ksp.get().pluginId)
}

android {
    namespace = "com.epiclabs.thinktok.data.local"
}

dependencies {
    implementation(project(":feature:main:repository:api"))
    implementation(project(":feature:main:domain:api"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    implementation(libs.room.ktx)
    implementation(libs.room.paging)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.coroutines.test)
}
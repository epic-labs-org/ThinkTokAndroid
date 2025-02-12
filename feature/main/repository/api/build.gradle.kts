plugins {
    alias(libs.plugins.android.module)
}

android {
    namespace = "com.epiclabs.thinktok.main.repository.api"
}

dependencies {
    implementation(project(":feature:main:domain:api"))
}
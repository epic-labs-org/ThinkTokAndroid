plugins {
    alias(libs.plugins.android.module)
}

android {
    namespace = "com.epiclabs.thinktok.main.domain.api"
}

dependencies {
    api(project(":core"))

    api(libs.coroutines.android)
}
plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}
dependencies {
    implementation("com.android.tools.build:gradle:8.8.0")
    implementation(gradleApi())
    implementation(kotlin("gradle-plugin", version = "2.0.0"))
}
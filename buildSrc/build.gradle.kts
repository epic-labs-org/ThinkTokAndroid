plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}
dependencies {
    //noinspection UseTomlInstead
    implementation("com.android.tools.build:gradle:8.8.0")
    implementation(gradleApi())
    implementation(kotlin("gradle-plugin", version = "2.0.0"))
    implementation("org.jlleitschuh.gradle:ktlint-gradle:12.1.2")
}
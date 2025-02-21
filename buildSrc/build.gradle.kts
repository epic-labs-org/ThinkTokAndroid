plugins {
    `kotlin-dsl`
    id("org.jlleitschuh.gradle.ktlint") version "12.1.2"
}
apply(plugin = "org.jlleitschuh.gradle.ktlint")

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
ktlint {
    android = false // If you're not using Android, set to false
    outputToConsole = true
    outputColorName = "RED"
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
    }
}
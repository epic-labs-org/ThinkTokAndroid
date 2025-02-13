package com.epiclabs.thinktok.buildsrc

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class AndroidModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        project.plugins.apply("org.jetbrains.kotlin.android")
        project.plugins.apply("org.jlleitschuh.gradle.ktlint")
        project.logger.lifecycle("AndroidModulePlugin applied to: ${project.name}")
        project.extensions.configure<LibraryExtension> {
            compileSdk = 35

            defaultConfig {
                minSdk = 24

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

        }

        project.extensions.configure<KtlintExtension> { // Use "configure" and the plugin name
            // Enable Android-specific linting rules
            android.set(true)
            // Fail the build if KtLint finds any issues
            ignoreFailures.set(true)
            verbose.set(true)
            enableExperimentalRules.set(true)
            filter {
                exclude("**/generated/**")
            }

            reporters {
                reporter(ReporterType.PLAIN)
            }
        }

        val ktlintCheck: TaskProvider<*> = project.tasks.named("ktlintFormat")
        project.tasks.named("preBuild").configure {
            dependsOn(ktlintCheck)
        }


        project.extensions.configure<KotlinAndroidProjectExtension> {
            jvmToolchain(21)
        }
    }
}
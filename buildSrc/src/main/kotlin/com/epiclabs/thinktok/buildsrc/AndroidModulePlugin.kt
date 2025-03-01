package com.epiclabs.thinktok.buildsrc

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        project.plugins.apply("org.jetbrains.kotlin.android")
        project
            .logger.lifecycle("AndroidModulePlugin applied to: ${project.name}")
        project.extensions.configure<LibraryExtension> {
            compileSdk = 35
            testOptions.unitTests.isIncludeAndroidResources = true

            addDefaultConfig()

            addBuildTypes(project, false)

            addCompileOptions()
        }

        project.extensions.configure<KotlinAndroidProjectExtension> {
            jvmToolchain(21)
        }
    }
}
package com.epiclabs.thinktok.buildsrc

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AppModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.logger.lifecycle("AppModulePlugin applied to: ${project.name}")
        project.plugins.apply("com.android.application")
        project.plugins.apply("org.jetbrains.kotlin.android")

        project.extensions.configure<BaseAppModuleExtension> {
            compileSdk = 35

            addDefaultConfig()

            addBuildTypes(project)

            addCompileOptions()

            addBuildFeatures()
        }
    }
}

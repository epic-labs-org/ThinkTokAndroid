package com.epiclabs.thinktok.buildsrc
import org.gradle.api.Plugin
import org.gradle.api.Project

class AppModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.logger.lifecycle("AppModulePlugin applied to: ${project.name}")
    }
}
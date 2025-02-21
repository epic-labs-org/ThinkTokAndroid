import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE
plugins {
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    id(libs.plugins.android.application.get().pluginId) apply false
    id(libs.plugins.android.library.get().pluginId) apply false
    id(libs.plugins.kotlin.android.get().pluginId) apply false
}

allprojects {
    // Apply to all projects (root and subprojects)
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnit()
    }
}
subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    afterEvaluate {
        project.extensions.configure<KtlintExtension> {
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
                reporter(PLAIN)
                reporter(CHECKSTYLE)
            }

        }

        tasks.matching { it.name == "preBuild" }.configureEach {
            dependsOn("ktlintFormat")
        }
    }
}
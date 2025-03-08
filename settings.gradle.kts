@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}


rootProject.name = "Think Tok"
include(":app")
include(":core")
include(":designsystem")
include(":data:remote")
include(":data:local")
include(":feature:main:ui")
include(":feature:main:domain")
include(":feature:main:domain:api")
include(":feature:main:presentation")
include(":feature:main:repository")
include(":feature:main:repository:api")

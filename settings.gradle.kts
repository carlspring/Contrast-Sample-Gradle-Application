rootProject.name = "Contrast-Sample-Gradle-Application"

// Plugin Dependency Resolution Management
pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

// Project Dependency Resolution Management
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

// This should be located in the settings.gradle.kts, because it allows you to preserve Gradle's cache for the
// buildscript. When it's in the `build.gradle.kts` file, each change you make to the file results in complete
// cache eviction.
buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("gradle.plugin.com.contrastsecurity:ContrastGradlePlugin:1.3.0")
    }
}

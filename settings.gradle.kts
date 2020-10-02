pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.dokka") {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
            }
        }
    }
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")
        mavenLocal()
        gradlePluginPortal()
    }
}

rootProject.name = "java-suppress-me"

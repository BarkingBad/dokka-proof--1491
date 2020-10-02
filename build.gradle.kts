plugins {
    java
    id("org.jetbrains.dokka") version "1.4.10-dev-72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")
    mavenCentral()
    mavenLocal()
    jcenter()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    dokkaPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4.10-dev-72")
}

tasks {
    val dokkaOutputDir = File("$rootDir/dokka")

    val dokkaHtml by getting(org.jetbrains.dokka.gradle.DokkaTask::class) {
        outputDirectory.set(dokkaOutputDir)

        dokkaSourceSets {

            val sourceSet by creating {
                sourceRoots.from(file("$rootDir/src/main/java"))

                perPackageOption {
                    prefix.set("make.me.s") // matches make.me.suppressed
                    suppress.set(true)
                }
            }
        }
    }
}

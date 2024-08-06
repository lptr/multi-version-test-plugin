plugins {
    `java-library`
}

repositories {
    maven {
        url = uri("https://repo.grdev.net/artifactory/libs-releases-local")
    }
    mavenCentral()
}

val apiVersion = "8.9"

dependencies {
    compileOnly("org.gradle.experimental:gradle-public-api:${apiVersion}")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.10.2")
        }
    }
}

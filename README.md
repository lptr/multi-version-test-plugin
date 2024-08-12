# Multi-version Gradle plugin example (WIP)

![](https://github.com/lptr/multi-version-test-plugin/actions/workflows/build.yaml/badge.svg)

This is an example of a multi-version plugin for Gradle.

## Building against a specific Gradle version

Since Gradle 8.9 you can use the `-Dorg.gradle.unsafe.suppress-gradle-api=true` system property to suppress `java-gradle-plugin` from adding the `gradleApi()` dependency (which would point to the Gradle runtime's API).
This way you can add your own Gradle API version, like so:

```kotlin
plugins {
    `java-gradle-plugin`
}

repositories {
    maven {
        url = uri("https://repo.gradle.org/artifactory/libs-releases")
    }
    mavenCentral()
}

val apiVersion = "8.9"

dependencies {
    implementation(project(":common"))
    implementation("org.gradle.experimental:gradle-public-api:${apiVersion}")
}
```

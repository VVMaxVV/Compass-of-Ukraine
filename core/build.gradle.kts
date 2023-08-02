plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

dependencies {
    api("io.insert-koin:koin-core:3.4.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
}

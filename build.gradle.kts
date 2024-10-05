plugins {
    kotlin("jvm") version "2.0.20"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
    id("com.adarshr.test-logger") version "4.0.0"
    id("org.jetbrains.kotlinx.kover") version "0.8.3"
}

group = "com.github.ogesaku"

repositories {
    mavenCentral()
}

dependencies {
    val versions = object {
        val coroutines = "1.8.1"
        val kotest = "5.9.1"
    }
    implementation("com.coditory.klog:klog:0.0.17")

    // unit tests
    testImplementation("io.kotest:kotest-runner-junit5:${versions.kotest}")
    testImplementation("io.kotest:kotest-assertions-core:${versions.kotest}")
    testImplementation("io.kotest:kotest-framework-datatest:${versions.kotest}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${versions.coroutines}")
    testImplementation("org.skyscreamer:jsonassert:1.5.3")
}

ktlint {
    version = "1.3.1"
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    compilerOptions {
        allWarningsAsErrors = true
    }
}

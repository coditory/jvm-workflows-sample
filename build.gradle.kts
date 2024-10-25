import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("jvm") version "2.0.21"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
    id("org.jetbrains.kotlinx.kover") version "0.8.3"
}

group = "com.coditory.sample"

repositories {
    mavenCentral()
}

dependencies {
    val coroutinesVersion = "1.8.1"
    implementation("com.coditory.klog:klog:0.0.12")
    implementation("com.coditory.quark:quark-context:0.1.20")

    // unit tests
    val kotestVersion = "5.8.0"
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-extensions-junitxml:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    testImplementation("org.skyscreamer:jsonassert:1.5.0")
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

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    testLogging {
        events = setOf(
            TestLogEvent.FAILED,
            TestLogEvent.STANDARD_ERROR,
            TestLogEvent.STANDARD_OUT,
            TestLogEvent.SKIPPED,
            TestLogEvent.PASSED,
        )
        exceptionFormat = TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
    // Required by kotest
    reports {
        junitXml.required.set(false)
    }
    systemProperty("gradle.build.dir", project.layout.buildDirectory.get().toString())
}

tasks.register("coverage") {
    dependsOn("koverXmlReport", "koverHtmlReport", "koverLog")
}

// Prints project version.
// Usage: ./gradlew version --quiet
tasks.register("version") {
    doLast {
        println(project.version)
    }
}

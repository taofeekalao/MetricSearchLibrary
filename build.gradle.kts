plugins {
    kotlin("jvm") version "1.9.23"
    id("org.jetbrains.dokka") version "1.9.20"
}

apply(plugin = "maven-publish")

group = "com.metric.search.visualisation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven")
}

dependencies {
    implementation(files("libs/Metric-space-framework-1.0-20211209.152843-1.jar"))
    implementation("org.jetbrains.kotlinx:kotlin-statistics-jvm:0.2.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("io.mockk:mockk:1.13.7")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "visualisation-library"
            from(components["kotlin"])
        }
    }
}
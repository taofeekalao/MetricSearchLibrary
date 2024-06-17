plugins {
    kotlin("jvm") version "1.9.23"
}

apply(plugin = "maven-publish")

group = "com.metric.search.visualisation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(files("libs/Metric-space-framework-1.0-20211209.152843-1.jar"))
    implementation("org.jetbrains.kotlinx:kandy-lets-plot:0.6.0")
    implementation("org.jetbrains.kotlinx:kotlin-statistics-jvm:0.2.1")
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
            from(components["java"])
        }
    }
}

plugins {
    kotlin("jvm") version "1.9.23"
}

apply(plugin = "maven-publish")

group = "com.metric.search.visualisation"
version = "1.0-SNAPSHOT"

tasks.register<Jar>("fatJar") {
    archiveClassifier.set("all")
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // Handle duplicate files by excluding them
}


repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven")
}

dependencies {
    implementation(files("libs/Metric-space-framework-1.0-20211209.152843-1.jar"))
    // https://mvnrepository.com/artifact/org.jetbrains.lets-plot/lets-plot-kotlin-api
//    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-api:2.0.1")

//    implementation("org.jetbrains.kotlinx:kandy-api:0.6.0-dev-48")
//    implementation("org.jetbrains.kotlinx:kandy-lets-plot:0.6.0")
    implementation("org.jetbrains.kotlinx:kotlin-statistics-jvm:0.2.1")
//    implementation("org.jetbrains.lets-plot:lets-plot-common:2.1.0")

    // https://mvnrepository.com/artifact/org.jetbrains.lets-plot/lets-plot-kotlin-jvm
//    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:4.7.3")
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
//            from(components["java"])
            from(components["kotlin"])

            // Include the fat JAR in the publication
            artifact(tasks.named("fatJar").get()) {
                classifier = "all"
            }
        }
    }
}
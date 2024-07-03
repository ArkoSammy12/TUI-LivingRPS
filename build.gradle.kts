plugins {
    kotlin("jvm") version "2.0.0"
}

group = property("maven_group")!!
val archiveBaseName = property("archive_base_name")!!
version = property("version")!!

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.googlecode.lanterna:lanterna:${property("lanterna_version")!!}")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
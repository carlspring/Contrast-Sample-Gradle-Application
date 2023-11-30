import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    `maven-publish`
    id("com.contrastsecurity.contrastplugin")
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.vehiclempg"
version = "0.0.1-SNAPSHOT"
description = "Vehicle MPG Webapp"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

springBoot {
    mainClass = "com.vehiclempg.Application"
    buildInfo()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("org.springframework.boot:spring-boot-starter-log4j:1.3.8.RELEASE")
    implementation("org.apache.logging.log4j:log4j-api:2.22.0")
    runtimeOnly("org.apache.logging.log4j:log4j-core:2.22.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.16.0")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mongodb")

    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")

    testImplementation("io.rest-assured:rest-assured")
    testImplementation("io.rest-assured:spring-mock-mvc")
}

contrastConfiguration {
    username = "username"
    apiKey = "asdf"
    serviceKey = "asdf"
    apiUrl = "http://localhost:19080/Contrast/api"
    orgUuid = "1234-1234-1234-1234"
    appName = "appNameHere"
    serverName = "serverNameHere"
    minSeverity = "Medium"
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
            showStackTraces = true
            exceptionFormat = TestExceptionFormat.SHORT
            events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
    }
}

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

//dependencies {
//    compile("org.springframework.boot:spring-boot-starter-web") {
//        exclude module: "spring-boot-starter-tomcat"
//    }
//    compile("org.springframework.boot:spring-boot-starter-jetty")
//    compile("org.springframework.boot:spring-boot-starter-actuator")
//    testCompile("junit:junit")
//}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-jersey:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-jetty:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
//    implementation("org.springframework.boot:spring-boot-starter-log4j:1.3.8.RELEASE")
    implementation("org.apache.logging.log4j:log4j-api:2.22.0")
    runtimeOnly("org.apache.logging.log4j:log4j-core:2.22.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.16.0")

    // Add testcontainers
    testImplementation("org.testcontainers:testcontainers:1.19.3")
    testImplementation("org.testcontainers:junit-jupiter:1.19.3")
    testImplementation("org.testcontainers:mongodb:1.19.3")

    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.0")

    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:3.0.1")
    testImplementation("io.rest-assured:rest-assured:5.3.2")
    testImplementation("io.rest-assured:spring-mock-mvc:5.3.2")
//    testImplementation("junit:junit:4.13.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

//apply plugin: "com.contrastsecurity.contrastplugin"
//
//
//contrastConfiguration {
//    username = "username"
//    apiKey = "asdf"
//    serviceKey = "asdf"
//    apiUrl = "http://localhost:19080/Contrast/api"
//    orgUuid = "1234-1234-1234-1234"
//    appName = "appNameHere"
//    serverName = "serverNameHere"
//    minSeverity = "Medium"
//}

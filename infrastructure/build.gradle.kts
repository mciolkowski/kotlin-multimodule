repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.flywaydb:flyway-core")
//    implementation("org.springframework.kafka:spring-kafka")
//    runtimeOnly("org.postgresql:postgresql")
//    testImplementation("org.testcontainers:kafka")
//    testImplementation("org.testcontainers:postgresql")
//    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.testcontainers:junit-jupiter")
    implementation(project(":domain"))
}

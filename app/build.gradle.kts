repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation(project(":domain"))
    implementation(project(":api"))
    implementation(project(":infrastructure"))
}
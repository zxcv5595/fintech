plugins {
    kotlin("plugin.jpa")
}

version = "0.0.1"


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")
    implementation("mysql:mysql-connector-java:8.0.25")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation(project(":api"))

}
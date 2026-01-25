plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Selenium
    implementation("org.seleniumhq.selenium:selenium-java:4.24.0")
// JUnit 5
    implementation("org.junit.jupiter:junit-jupiter:5.10.3")

    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")

    implementation("com.codeborne:selenide:7.12.0")

//    testImplementation(platform("org.junit:junit-bom:5.10.0"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
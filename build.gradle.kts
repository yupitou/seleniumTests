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
    testImplementation("org.seleniumhq.selenium:selenium-java:4.24.0")
// JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")

    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")

    testImplementation("com.codeborne:selenide:7.12.0")

//    testImplementation(platform("org.junit:junit-bom:5.10.0"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
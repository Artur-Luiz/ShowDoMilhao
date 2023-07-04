plugins {
    id("java")
}

group = "com.showdomilhao"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.kyori:adventure-text-minimessage:4.14.0")
    implementation("net.kyori:adventure-text-serializer-ansi:4.14.0")
}

tasks.test {
    useJUnitPlatform()
}
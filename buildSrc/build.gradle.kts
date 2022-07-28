plugins {
    kotlin("jvm") version "1.7.10"
    java
    `java-gradle-plugin`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
gradlePlugin {
    plugins {
        create("IncrementLintPlugin") {
            id = "com.zhengdianfang.lint"
            version = "1.0.0"
            implementationClass = "com.zhengdianfang.lint.IncrementLintPlugin"
        }
    }
}
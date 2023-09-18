plugins {
    java
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.huoranger"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")


    repositories {
        maven("https://maven.aliyun.com/repository/public")
        mavenCentral()
    }



    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

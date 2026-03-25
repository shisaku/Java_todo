plugins {
	java
	id("org.springframework.boot") version "3.5.12-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    // Spring MVC によるWebアプリ開発の基盤
    implementation("org.springframework.boot:spring-boot-starter-web")
    // 開発時のホットリロード
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    // JUnit などテスト用ライブラリ一式
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // JUnit 5 のテストランナー（テスト実行エンジン）※テスト実行時のみ
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // docker-compose.ymlを自動で立ち上げる
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    // Thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    // Spring Data JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // PostgreSQL の JDBCドライバ
    runtimeOnly("org.postgresql:postgresql")
    // バリデーション
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
tasks.withType<Test> {
	useJUnitPlatform()
}

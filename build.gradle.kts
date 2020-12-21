import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4.21"
	id("org.jetbrains.compose") version "0.3.0-build135"
}

group = "org.sdkotlin"
version = "1.0"

repositories {
	jcenter()
	mavenCentral()
	maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
	implementation(compose.desktop.currentOs)

	val junitVersion = "5.7.0"
	testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks {
	test {
		useJUnitPlatform()
	}

	withType<KotlinCompile> {
		kotlinOptions.jvmTarget = "11"
	}

	named<Wrapper>("wrapper") {
		// https://github.com/gradle/gradle/issues/12660
		gradleVersion = "6.8-rc-3"
		distributionType = ALL
	}
}

compose.desktop {
	application {
		mainClass = "org.sdkotlin.compose.MainKt"
		nativeDistributions {
			targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
			packageName = "compose-desktop-demo"
		}
	}
}

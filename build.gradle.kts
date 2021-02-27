import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4.30"
	id("org.jetbrains.compose") version "0.3.0"
}

group = "org.sdkotlin"
version = "1.0.0"

dependencies {
	implementation(compose.desktop.currentOs)

	val junitVersion = "5.7.1"
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
		gradleVersion = "6.8.3"
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

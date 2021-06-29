import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.github.benmanes.gradle.versions.updates.gradle.GradleReleaseChannel.CURRENT
import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.5.10"
	id("org.jetbrains.compose") version "0.4.0"
	id("com.github.ben-manes.versions") version "0.39.0"
}

group = "org.sdkotlin"
version = "1.0.0"

dependencies {
	implementation(compose.desktop.currentOs)

	implementation(platform("org.junit:junit-bom:5.7.2"))

	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
	test {
		useJUnitPlatform()
	}

	withType<KotlinCompile> {
		kotlinOptions.jvmTarget = "11"
	}

	withType<DependencyUpdatesTask> {
		rejectVersionIf {
			isNonStable(candidate.version)
		}
		gradleReleaseChannel = CURRENT.id
	}

	named<Wrapper>("wrapper") {
		gradleVersion = "7.1"
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

fun isNonStable(version: String): Boolean {
	val stableKeyword = listOf("RELEASE", "FINAL", "GA").any {
		version.toUpperCase()
			.contains(it)
	}
	val unstableKeyword =
		listOf("""M\d+""").any { version.toUpperCase().contains(it.toRegex()) }
	val regex = "^[0-9,.v-]+(-r)?$".toRegex()
	val isStable = (stableKeyword && !unstableKeyword) || regex.matches(version)
	return isStable.not()
}

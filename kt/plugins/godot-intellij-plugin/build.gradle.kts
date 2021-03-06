import org.jetbrains.changelog.closure
import org.jetbrains.changelog.markdownToHTML
import plugins.intellij.BuildConfig
import plugins.intellij.VersionRange

plugins {
    // Java support
    id("java")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm")
    // gradle-intellij-plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
    id("org.jetbrains.intellij") version "0.6.5"
    // gradle-changelog-plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
    id("org.jetbrains.changelog") version "0.6.2"
    // detekt linter - read more: https://detekt.github.io/detekt/gradle.html
    id("io.gitlab.arturbosch.detekt") version "1.14.2"
    // ktlint linter - read more: https://github.com/JLLeitschuh/ktlint-gradle
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
}

val buildMatrix: Map<String, BuildConfig> = mapOf(
    "IJ203" to BuildConfig(
        "203.5981.155",
        "IJ2020.3",
        "IJ183",
        VersionRange("203.1", "203.*"),
        listOf("2020.1.4", "2020.2.3", "2020.3"),
        listOf("java", "org.jetbrains.kotlin:1.4.0-release-IJ2020.2-1")
    )
)

group = "com.utopia-rise"
version = "0.0.1"
val sdkVersion = project.properties["godot.plugins.intellij.version"] ?: "IJ203"
val settings = checkNotNull(buildMatrix[sdkVersion])

// Configure gradle-intellij-plugin plugin.
// Read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    pluginName = "godot-jvm-idea-plugin"
    version = settings.sdk
    type = "IC"
    downloadSources = true
    updateSinceUntilBuild = true

    setPlugins(*settings.deps.toTypedArray())
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.14.2")
    implementation("com.utopia-rise:jvm-godot-resource-serialization")
}

// Configure detekt plugin.
// Read more: https://detekt.github.io/detekt/kotlindsl.html
detekt {
    config = files("$projectDir/detekt-config.yml")
    buildUponDefaultConfig = true

    reports {
        html.enabled = false
        xml.enabled = false
        txt.enabled = false
    }
}

tasks {
    patchPluginXml {
        version("${project.version}-${settings.prefix}")
        sinceBuild(settings.version.since)
        untilBuild(settings.version.until)

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription(
            closure {
                File("$projectDir/README.md").readText().lines().run {
                    val start = "<!-- Plugin description -->"
                    val end = "<!-- Plugin description end -->"

                    if (!containsAll(listOf(start, end))) {
                        throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                    }
                    subList(indexOf(start) + 1, indexOf(end))
                }.joinToString("\n").run { markdownToHTML(this) }
            }
        )

        // Get the latest available change notes from the changelog file
        changeNotes(
            closure {
                changelog.getLatest().toHTML()
            }
        )
    }

    runPluginVerifier {
        ideVersions(settings.ideVersionsForVerifierTask.joinToString(", "))
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token(System.getenv("PUBLISH_TOKEN"))
        // pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://jetbrains.org/intellij/sdk/docs/tutorials/build_system/deployment.html#specifying-a-release-channel
        channels(version.toString().split('-').getOrElse(1) { "default" }.split('.').first())
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

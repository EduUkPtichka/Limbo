@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion


plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugins)
}

kotlin {
    /*
     *   Справедливо использовать jvm target, так и для jvm, так и для android если
     * вам не нужно:
     * - Что-то специфическое из Android.
     * - какой-то jvm инструмент который не поддерживается jvm android-а.
     */
    jvm() {
        withJava()
        // compileTaskProvider.configure
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

}
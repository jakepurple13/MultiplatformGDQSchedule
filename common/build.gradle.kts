plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    kotlin("native.cocoapods")
    id("kotlinx-serialization")
    id("com.squareup.sqldelight")
}

group = "com.programmersbox"
version = "1.0-SNAPSHOT"

@OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
kotlin {
    android()
    jvm("desktop")
    js(IR) {
        browser()
        useCommonJs()
        binaries.executable()
        nodejs()
    }
    ios()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "common"
            isStatic = false
            embedBitcode(org.jetbrains.kotlin.gradle.plugin.mpp.Framework.BitcodeEmbeddingMode.DISABLE)
            export("io.github.softartdev:sqlcipher-ktn-pod:1.3")
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
        useLibraries()
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.all {
            freeCompilerArgs += listOf(
                "-linker-option", "-framework", "-linker-option", "Metal",
                "-linker-option", "-framework", "-linker-option", "CoreText",
                "-linker-option", "-framework", "-linker-option", "CoreGraphics",
                "-Xdisable-phases=VerifyBitcode"
            )
            linkerOpts += "-lsqlite3"
        }
    }

    sourceSets {
        val sqldelight = "1.5.4"
        val ktorVersion = "2.2.2"
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.ui)
                api(compose.foundation)
                api(compose.materialIconsExtended)
                api(compose.material3)
                api("io.ktor:ktor-client-core:$ktorVersion")
                api("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                api("io.ktor:ktor-client-logging:$ktorVersion")
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                api("com.squareup.sqldelight:runtime:$sqldelight")
                api("com.squareup.sqldelight:coroutines-extensions:$sqldelight")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.5.1")
                api("androidx.core:core-ktx:1.9.0")
                api("io.ktor:ktor-client-android:$ktorVersion")
                api("org.jsoup:jsoup:1.15.3")
                api("com.squareup.sqldelight:android-driver:$sqldelight")
                api("androidx.work:work-runtime-ktx:2.7.1")
            }
        }

        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }

        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                api("io.ktor:ktor-client-cio:$ktorVersion")
                api("org.jsoup:jsoup:1.15.3")
                api("com.squareup.sqldelight:sqlite-driver:$sqldelight")
            }
        }

        val desktopTest by getting

        val jsMain by getting {
            dependencies {
                api(compose.web.core)
                api("io.ktor:ktor-client-js:$ktorVersion")
                api(npm("@aghajari/jssoup", "1.0.2", generateExternals = false))
                //api(npm("@jolie/jsoup", "1.0.1"))
                api("com.squareup.sqldelight:sqljs-driver:$sqldelight")
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependencies {
                api("io.ktor:ktor-client-darwin:$ktorVersion")
                api("com.squareup.sqldelight:native-driver:$sqldelight")
                api("io.github.softartdev:sqlcipher-ktn-pod:1.3")
            }
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }

    explicitApi()
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    database("GDQReminderDatabase") {
        packageName = "com.programmersbox.reminders"
    }
    linkSqlite = true
}
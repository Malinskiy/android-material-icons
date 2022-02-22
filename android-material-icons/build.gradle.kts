plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 4
        targetSdk = 22
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    lint {
        isAbortOnError = true
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}

afterEvaluate {
    val user = System.getenv("SONATYPE_USERNAME")
    val password = System.getenv("SONATYPE_PASSWORD")
    val snapshotDeployUrl = System.getenv("SONATYPE_SNAPSHOTS_URL")
        ?: "https://oss.sonatype.org/content/repositories/snapshots/"
    val releaseDeployUrl = System.getenv("SONATYPE_RELEASES_URL")
        ?: "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
    
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.malinskiy"
                artifactId = "materialicons"
                version = System.getenv("GIT_TAG_NAME") ?: "1.0.3"

                pom?.apply {
                    name.set("MaterialIcons")
                    url.set("https://github.com/Malinskiy/android-material-icons")
                    description.set("Easy to use material icons for Android")

                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }

                    developers {
                        developer {
                            id.set("Malinskiy")
                            name.set("Anton Malinskiy")
                            email.set("anton@malinskiy.com")
                        }
                    }

                    scm {
                        url.set("https://github.com/Malinskiy/android-material-icons.git")
                        connection.set("scm:git:ssh://github.com/Malinskiy/android-material-icons")
                        developerConnection.set("scm:git:ssh://github.com/Malinskiy/android-material-icons")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "OSSHR"
                credentials {
                    this.username = user
                    this.password = password
                }
                url = uri(releaseDeployUrl)
            }
        }
    }

    val passphrase = System.getenv("GPG_PASSPHRASE")
    passphrase?.let {
        project.plugins.apply("signing")

        val publishing = project.the(PublishingExtension::class)
        project.configure<SigningExtension> {
            sign(publishing.publications.getByName("release"))
        }

        project.extra.set("signing.keyId", "1131CBA5")
        project.extra.set("signing.password", passphrase)
        project.extra.set("signing.secretKeyRingFile", "${project.rootProject.rootDir}/.buildsystem/secring.gpg")
    }
}

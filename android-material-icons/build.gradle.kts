plugins {
    id("com.android.library")
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
    testImplementation("junit:junit:4.12")
}

//TODO: set up publishing
//apply from: 'https://raw.github.com/chrisbanes/gradle-mvn-push/master/gradle-mvn-push.gradle'

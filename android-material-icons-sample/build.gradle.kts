plugins {
    id("com.android.application")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 14
        targetSdk = 22
        applicationId = "com.malinskiy.materialicons.sample"
    }
}

dependencies {
    implementation(project(":android-material-icons"))

    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}

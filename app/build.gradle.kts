plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.opsc"
    compileSdk = 34
    viewBinding.enable = true

    defaultConfig {
        applicationId = "com.example.opsc"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val camerax_version = "1.1.0"

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity:1.8.0")
    implementation("com.google.firebase:firebase-database:20.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Specify a dependency on the CameraX Camera2 library with the camerax_version
    // of 1.1.0. Camera2 allows developers to access and control the camera hardware
    implementation("androidx.camera:camera-camera2:${camerax_version}")
    // Specify the dependencies on the CameraX Lifecycle and CameraX View libraries
    // using the camerax_version to reference the version number.

    // camera-lifecycle: Simplifies the management of the camera's lifecycle (properly opened,
    // closed, and released based on the lifecycle of the associated LifecycleOwner (such as an Activity)
    implementation("androidx.camera:camera-lifecycle:${camerax_version}")
    // camera-view: provides a set of UI components that can be used to create camera-related UI's to the
    // app. Such as PreviewView
    implementation("androidx.camera:camera-view:${camerax_version}")
}
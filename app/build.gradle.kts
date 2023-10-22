import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

val properties = Properties()
properties.load(project.rootProject.file("private.properties").reader())

android {
    namespace = "com.manuelapk.pelis"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.manuelapk.pelis"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "API_KEY", properties.getProperty("api.key"))
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "API_KEY", properties.getProperty("api.key"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")//alternativa: kotlin flow
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")//alternativa: ktor
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // dagger
    implementation("com.google.dagger:hilt-android:2.48.1") //alternativa: koin
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    //TODO: work manager

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //TODO: añadir mockito

    // coil image
    implementation("io.coil-kt:coil:2.4.0")

    // room db
    val roomVersion = "2.6.0"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

}
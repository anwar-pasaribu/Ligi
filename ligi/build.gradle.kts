plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    `maven-publish`
}

android {
    namespace = "com.unwur.ligi"
    compileSdk = 34

    defaultConfig {
        minSdk = 30
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        aarMetadata {
            minCompileSdk = 30
        }
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)

}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.unwur.ligi"
            artifactId = "ui"
            version = "1.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

//configure<PublishingExtension> {
//    publishing {
//        publications {
//            create<MavenPublication>("maven") {
//                groupId = "com.unwur.ligi"
//                artifactId = "ui"
//                version = "1.0"
//
//                from(components["release"])
//            }
//        }
//    }
//}


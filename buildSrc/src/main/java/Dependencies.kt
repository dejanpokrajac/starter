object AppConfig {
    val applicationId = "com.sample.starter"
    val versionCode = 100
    val versionName = "1.0.0"
}

object Modules {
    val common = ":common"

    val local = ":data:local"
    val remote = ":data:remote"
    val model = ":data:model"
    val repository = ":data:repository"

    val featureRepos = ":features:repos"
}

object Versions {
    val kotlin = "1.3.61"
    val gradle = "3.5.3"
    val compileSdk = 29
    val minSdk = 21
    val targetSdk = 29
    val buildTools = "29.0.2"
    val appCompat = "1.1.0"
    val coreKtx = "1.1.0"
    val material = "1.0.0"
    val constraintLayout = "1.1.3"
    val junit = "4.12"
    val androidJunit = "1.1.1"
    val espressoCore = "3.2.0"
    val retrofit = "2.5.0"
    val retrofitCoroutines = "0.9.2"
    val retrofitGson = "2.4.0"
    val gson = "2.8.5"
    val okHttp = "3.12.1"
    val coroutines = "1.1.1"
    val koin = "1.0.2"
    val lifecycle = "2.2.0"
    val navigation = "2.1.0"
    val room = "2.2.3"
    val recyclerview = "1.0.0"
    val glide = "4.9.0"
}

object Libraries {
    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val material = "com.google.android.material:material:${Versions.material}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycle = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val navigation = "androidx.navigation:navigation-ui:${Versions.navigation}"
    val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}

object TestLibraries {
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val junit = "junit:junit:${Versions.junit}"
    val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val koin = "org.koin:koin-test:${Versions.koin}"
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}
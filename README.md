# Grow-Application
What if all buying and selling of stocks and mutual funds are done with just one click. Just one click will help you to analyze every stock and compare which one is better and will provide the best result in the long run and Just one will help you to explore more stocks.

![grow](https://user-images.githubusercontent.com/81345503/143854716-83f8900c-9aa1-4115-af2a-231d979d6bcd.png)


# 🔗Open-Source Library

* [Glide](https://github.com/bumptech/glide)
* [Retrofit](https://square.github.io/retrofit/)
* [Firebase](https://firebase.google.com/docs/auth)
* [Dependency Injection](https://developer.android.com/training/dependency-injection/hilt-android)
* [Jetpack](https://developer.android.com/jetpack)
* [Biometric Authentication](https://developer.android.com/training/sign-in/biometric-auth)
* [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
* [Room Database](https://developer.android.com/training/data-storage/room)
* [ViewModel and LiveData](https://developer.android.com/codelabs/basic-android-kotlin-training-livedata#0)


# Things we used while making this application
* MVVM-Architecture
* GitHub
* Recycler View
* Retrofit Library
* API
* Search Stocks
* Fragments-Navigation
* Biometric Authentication
* Firebase

# Tech Stack ✨

* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://kotlinlang.org/)

# Clone this Repo To Your System Using Android Studio✨

* Step 1: Open your Android Studio then go to the File > New > Project from Version Control as shown in the below image.
* Step 2: After clicking on the Project from Version Control a pop-up screen will arise like below. In the Version control choose Git from the drop-down menu.
* Step 3: Then at last paste the link in the URL and choose your Directory. Click on the Clone button and you are done.

# Clone this Repo To Your System Using GitBash✨

* Open Git Bash

* If Git is not already installed, it is super simple. Just go to the Git Download Folder and follow the instructions.

* Go to the current directory where you want the cloned directory to be added.

* To do this, input cd and add your folder location. You can add the folder location by dragging the folder to Git bash.

* Go to the page of the repository that you want to clone

* Click on “Clone or download” and copy the URL.

* Use the git clone command along with the copied URL from earlier. $ git clone https://github.com/chekeAditya/Grow-Application

* Press Enter. $ git clone https://github.com/chekeAditya/Grow-Application Cloning into Git … remote: Counting objects: 13, done. remote: Compressing objects: 100% (13/13), done. remove: Total 13 (delta 1), reused 0 (delta 1) Unpacking objects: 100% (13/13), done.

Congratulations, you have created your first local clone from your remote Github repository.

Open Android Studio. Go to File > New > Project From Version Control. Copy the link of this repositary. Paste the link in Url Box of Android Studio window and click on "Clone" button.

# Dependencies 
  

    //navigation
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    //firebase
    implementation 'com.google.firebase:firebase-auth:21.0.1'
    implementation 'com.google.android.gms:play-services-auth:19.2.0'

    //biometric
    implementation 'androidx.biometric:biometric:1.1.0'

    //Retrofit
    def retrofit2_version = "2.9.0"
    def okhttp3_version = "4.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit2_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    implementation "com.squareup.okhttp3:okhttp:$okhttp3_version"

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    //Anko
    def anko_version = '0.10.0'
    implementation "org.jetbrains.anko:anko-commons:$anko_version"
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.0-beta01'

    //Room
    implementation 'androidx.room:room-ktx:2.3.0'
    kapt 'androidx.room:room-compiler:2.3.0'

    // ViewModel and LiveData
    def arch_version = '2.2.0-alpha01'
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"

    //hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    //google
    implementation 'com.google.android.gms:play-services-auth:19.2.0'

    //gif
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.22'

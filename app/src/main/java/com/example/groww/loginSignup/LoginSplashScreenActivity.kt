package com.example.groww.loginSignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.groww.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class LoginSplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_splash_screen)

        runBlocking {
            showSplashScreen1()
//            showSplashScreen3()
        }
    }

    private suspend fun showSplashScreen1() {
        delay(1000)
        val fragment = SplashScreen1()
        supportFragmentManager.commit {
            replace(R.id.containerView, fragment)
        }
//        showSplashScreen2()
    }

    private suspend fun showSplashScreen2() {
        delay(1000)
        val fragment = SplashScreen2()
        supportFragmentManager.commit {
            replace(R.id.containerView, fragment)
        }
//        showSplashScreen3()
    }

    private suspend fun showSplashScreen3() {
        delay(1000)
        val fragment = SplashScreen3()
        supportFragmentManager.commit {
            replace(R.id.containerView, fragment)
        }
    }

}


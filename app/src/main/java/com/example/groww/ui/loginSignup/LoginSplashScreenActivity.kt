package com.example.groww.ui.loginSignup

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.groww.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginSplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_splash_screen)

        CoroutineScope(Dispatchers.Main).launch {
            Handler().postDelayed({
                val fragment = SplashScreen1()
                supportFragmentManager.commit {
                    replace(R.id.containerView, fragment)
                }
            }, 2000)
        }

//        CoroutineScope(Dispatchers.Main).launch {
//            Handler().postDelayed({
//                val fragment2 = SplashScreen2()
//                supportFragmentManager.commit {
//                    replace(R.id.containerView, fragment2)
//                }
//            }, 1500)
//        }

        CoroutineScope(Dispatchers.Main).launch {
            val fragment2 = SplashScreen2()
            supportFragmentManager.commit {
                replace(R.id.containerView, fragment2)
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            val fragment3 = SplashScreen3()
            supportFragmentManager.commit {
                replace(R.id.containerView, fragment3)
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            Handler().postDelayed({
                val fragment = SplashScreen1()
                supportFragmentManager.commit {
                    replace(R.id.containerView, fragment)
                }
            }, 1500)
        }
    }
}


package com.example.groww.loginSignup

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_splash_screen2.*
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SplashScreen2 : Fragment(R.layout.fragment_splash_screen2) {

    var handler: Handler? = null
    private val RC_SIGN_IN = 100
    var mGoogleSignInClient: GoogleSignInClient? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler = Handler()
        handler!!.postDelayed({
            CoroutineScope(Dispatchers.Main).launch {
                Navigation.findNavController(view)
                    .navigate(R.id.action_splashScreen2_to_splashScreen3)
            }
        }, 1000)


//        btnContinueWithGoogle2.setOnClickListener {
//
//        }
//
//        btnContinueWithEmail2.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_splashScreen2_to_enterEmail)
//        }
    }

}
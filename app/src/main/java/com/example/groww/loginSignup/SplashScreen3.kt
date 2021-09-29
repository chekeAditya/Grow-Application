package com.example.groww.loginSignup

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_splash_screen3.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashScreen3 : Fragment(R.layout.fragment_splash_screen3) {


    var handler: Handler? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler = Handler()
        handler!!.postDelayed({
            CoroutineScope(Dispatchers.Main).launch {
                Navigation.findNavController(view)
                    .navigate(R.id.action_splashScreen3_to_splashScreen1)
            }
        },1000)

//        btnContinueWithGoogle3.setOnClickListener {
//
//        }
//
//        btnContinueWithEmail3.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_splashScreen3_to_enterEmail)
//        }
    }

}
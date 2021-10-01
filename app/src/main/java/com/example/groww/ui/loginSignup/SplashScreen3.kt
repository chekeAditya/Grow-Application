package com.example.groww.ui.loginSignup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_splash_screen3.*

class SplashScreen3 : Fragment(R.layout.fragment_splash_screen3) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnContinueWithEmail3.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_splashScreen3_to_signupEnterEmail)
        }
        btnContinueWithGoogle3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_splashScreen3_to_fingerPrintVerification)
        }
    }

}
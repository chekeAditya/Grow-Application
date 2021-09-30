package com.example.groww.ui.loginSignup.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R

class FingerPrintVerification : Fragment(R.layout.fragment_finger_print_verification) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO Check 1 :- Android version should be greater or equal to Marshmallow
        //TODO Check 2 :- Device has fingerprint Scanner
        //TODO Check 3 :- Device has fingerprint Scanner

//        Handler().postDelayed({
//
//            val intent = Intent(activity,HomeActivity::class.java)
//            startActivity(intent)
//        },3000
//        )

        Navigation.findNavController(view).navigate(R.id.action_fingerPrintVerification_to_exploreFragment)
    }

}
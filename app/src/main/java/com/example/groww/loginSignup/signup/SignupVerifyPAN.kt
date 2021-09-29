package com.example.groww.loginSignup.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_signup_verify_p_a_n.*

class SignupVerifyPAN : Fragment(R.layout.fragment_signup_verify_p_a_n) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSPCreateAccount.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_signupVerifyPAN_to_fingerPrintVerification)
        }
    }

}
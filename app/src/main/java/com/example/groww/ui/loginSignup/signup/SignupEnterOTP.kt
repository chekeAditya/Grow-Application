package com.example.groww.ui.loginSignup.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_signup_enter_o_t_p.*

class SignupEnterOTP : Fragment(R.layout.fragment_signup_enter_o_t_p) {

    val args: SignupEnterOTPArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSPVerifyEmailID.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_signupEnterOTP_to_signupEnterMobileNumber)
        }
        etEPEmailAddress.text = args.emailId
    }

}
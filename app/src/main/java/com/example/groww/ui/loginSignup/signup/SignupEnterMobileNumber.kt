package com.example.groww.ui.loginSignup.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_signup_enter_mobile_number.*


class SignupEnterMobileNumber : Fragment(R.layout.fragment_signup_enter_mobile_number) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSpSendOTP.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_signupEnterMobileNumber_to_signupEnterMobileOTP)
        }
    }

}
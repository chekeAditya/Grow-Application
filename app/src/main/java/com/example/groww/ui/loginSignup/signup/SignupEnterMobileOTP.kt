package com.example.groww.ui.loginSignup.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_signup_enter_mobile_o_t_p.*

class SignupEnterMobileOTP : Fragment(R.layout.fragment_signup_enter_mobile_o_t_p) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSpVerifyOTP.setOnClickListener {
            if (etSPOTP.length() > 0) {
                Navigation.findNavController(it)
                    .navigate(R.id.action_signupEnterMobileOTP_to_signupVerifyPAN)
            }
        }
    }

}
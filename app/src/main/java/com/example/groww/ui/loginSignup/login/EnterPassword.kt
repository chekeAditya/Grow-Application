package com.example.groww.ui.loginSignup.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_enter_email.*
import kotlinx.android.synthetic.main.fragment_enter_password.*

class EnterPassword : Fragment(R.layout.fragment_enter_password) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnEPEnter.setOnClickListener {
            if (isEmailValid() && isPasswordValid()) {
                Navigation.findNavController(it)
                    .navigate(R.id.action_enterPassword_to_fingerPrintVerification)
            }
        }
    }


    private fun isEmailValid(): Boolean {
        return if (etEPEmailAddress.text.toString().isNotEmpty()) {
            true
        } else {
            etEPEmailAddress.error = "Please enter valid email address"
            false
        }
    }

    private fun isPasswordValid(): Boolean {
        return if (epEtPassword.text.toString().length >= 8) {
            true
        } else {
            epEtPassword.error = "Please enter valid Password"
            false
        }
    }

}   
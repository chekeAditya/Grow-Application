package com.example.groww.ui.loginSignup.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_signup_enter_email.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupEnterEmail : Fragment(R.layout.fragment_signup_enter_email) {

    private val emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            btnSPNext.setOnClickListener {
                if (isEmailValid()) {
                    val action = SignupEnterEmailDirections.actionSignupEnterEmailToSignupEnterOTP(
                        etSPEmailAddress.text.toString()
                    )
                    Navigation.findNavController(it)
                        .navigate(action)
                }
            }
        }
    }

    private fun isEmailValid(): Boolean {
        return if (etSPEmailAddress.text.toString().isNotEmpty()) {
            true
        } else {
            etSPEmailAddress.error = "Please enter valid email address"
            false
        }
    }
}
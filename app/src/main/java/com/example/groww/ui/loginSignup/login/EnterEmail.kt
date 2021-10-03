package com.example.groww.ui.loginSignup.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_enter_email.*
import kotlinx.android.synthetic.main.fragment_signup_enter_email.*

class EnterEmail : Fragment(R.layout.fragment_enter_email) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnEENext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_enterEmail_to_enterPassword)
        }

    }

    private fun isEmailValid(): Boolean {
        return if (etEEEmailAddress.text.toString().isNotEmpty()) {
            true
        } else {
            etEEEmailAddress.error = "Please enter valid email address"
            false
        }
    }

}
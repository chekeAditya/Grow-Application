package com.example.groww.loginSignup.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_enter_password.*

class EnterPassword : Fragment(R.layout.fragment_enter_password) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnEPEnter.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_enterPassword_to_fingerPrintVerification)
        }
    }

}   
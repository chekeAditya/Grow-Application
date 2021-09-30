package com.example.groww.ui.loginSignup

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R

class Loading : Fragment(R.layout.fragment_loading) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
           Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_exploreFragment)
        }, 2000)
    }
}
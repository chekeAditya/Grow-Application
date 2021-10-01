package com.example.groww.ui.loginSignup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import com.example.groww.ui.addMoney.explore.HomeActivity

class Loading : Fragment(R.layout.fragment_loading) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToLoginSignUpActivity()
//        goToExploreHomeActivity()
//        goToProfileActivity()
//        goToSearchActivity()
    }

    private fun goToSearchActivity() {
        Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_searchActivity)
    }

    private fun goToLoginSignUpActivity() {
        Handler().postDelayed({
            Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_splashScreen1)
        }, 2000)
    }

    private fun goToProfileActivity() {
        Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_profileActivity)
    }

    private fun goToExploreHomeActivity() {
        Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_homeActivity)
    }
}
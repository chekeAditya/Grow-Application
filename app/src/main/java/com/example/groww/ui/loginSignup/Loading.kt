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

//        gotoLoginUsingActivity()
        goToLoginSignUpActivityWithFragment()
//        goToExploreHomeActivity()
//        goToProfileActivity()
//       goToSearchActivity()
    }

    private fun gotoLoginUsingActivity() {
        Handler().postDelayed({
        val intent = Intent(context,LoginSplashScreenActivity::class.java)
        startActivity(intent)
        }, 2000)
    }

    private fun goToSearchActivity() {
        Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_searchActivity)
    }

    private fun goToLoginSignUpActivityWithFragment() {
        Handler().postDelayed({
            Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_splashScreen1)
        }, 2000)
    }
    
    private fun goToExploreHomeActivity() {
        Navigation.findNavController(requireView()).navigate(R.id.action_loading_to_homeActivity)
    }
}
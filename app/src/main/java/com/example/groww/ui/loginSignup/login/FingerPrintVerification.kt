package com.example.groww.ui.loginSignup.login

import android.hardware.biometrics.BiometricManager
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_finger_print_verification.*
import java.util.concurrent.Executor

@AndroidEntryPoint
class FingerPrintVerification : Fragment(R.layout.fragment_finger_print_verification) {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO Check 1 :- Android version should be greater or equal to Marshmallow
        //TODO Check 2 :- Device has fingerprint Scanner
        //TODO Check 3 :- Device has fingerprint Scanner
        executor = ContextCompat.getMainExecutor(requireContext())
        biometricPrompt = BiometricPrompt(requireActivity(),executor,object : BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                //auth error, stop task that requires auth
                tvEnterPin.text = "Authentication Error: $errString"
                Toast.makeText(requireContext(), "Please Try Again :  $errString", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                //auth succeed do task that require auth
                Handler().postDelayed({
                ivFingerPrintLight.setImageResource(R.drawable.ic_baseline_fingerprint_light_green_24)
                },1000)
                Navigation.findNavController(view).navigate(R.id.action_fingerPrintVerification_to_homeActivity)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(requireContext(), "Failed to Show pls try again", Toast.LENGTH_SHORT).show()
            }
        })


        promptInfo = BiometricPrompt.PromptInfo.Builder ()
            .setTitle("Biometric Authentication")
            .setSubtitle("Verify Using Fingerprint Authentication")
            .setNegativeButtonText("Use Password")
            .build()
        biometricPrompt.authenticate(promptInfo)

//        Handler().postDelayed({
//
//            val intent = Intent(activity,HomeActivity::class.java)
//            startActivity(intent)
//        },3000
//        )
    }

}

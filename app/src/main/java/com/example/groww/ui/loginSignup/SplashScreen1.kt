package com.example.groww.ui.loginSignup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import com.example.groww.ui.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_splash_screen.*


class SplashScreen1 : Fragment(R.layout.fragment_splash_screen1) {

    companion object {
        private const val RC_SIGN_IN = 1
    }

    private lateinit var mAuth: FirebaseAuth
    private var account: GoogleSignInAccount? = null
    private var acct: GoogleSignInAccount? = null
    lateinit var googleSignInClient: GoogleSignInClient

//    override fun onStart() {
//        super.onStart()
//        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
//        Navigation.findNavController(requireView())
//            .navigate(R.id.action_splashScreen1_to_splashScreen2)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
            googleSignInClient = GoogleSignIn.getClient(requireContext(), gso);

        btnContinueWithGoogle.setOnClickListener {
            signIn()
        }

        btnContinueWithEmail.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_splashScreen1_to_signupEnterEmail)
        }
    }

    fun signIn() {
        val signInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Navigation.findNavController(requireView())
                .navigate(R.id.action_splashScreen1_to_splashScreen2)
        } catch (e: ApiException) {
            Toast.makeText(context, "Error in SplashScreen ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}


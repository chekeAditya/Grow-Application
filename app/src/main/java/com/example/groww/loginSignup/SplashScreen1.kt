package com.example.groww.loginSignup

import android.content.Context
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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_splash_screen1.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SplashScreen1 : Fragment(R.layout.fragment_splash_screen1) {

    companion object {
        private const val RC_SIGN_IN = 1
    }

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private var accout: GoogleSignInAccount? = null
    private var acct: GoogleSignInAccount? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            Navigation.findNavController(requireView())
                .navigate(R.id.action_splashScreen1_to_splashScreen2)
        }, 1500)
        return super.onCreateView(inflater, container, savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        CoroutineScope(Dispatchers.Main).launch {
//            googleSignIn()
//        }

//        btnContinueWithGoogle.setOnClickListener {
//            CoroutineScope(Dispatchers.Main).launch {
//                signInMethod()
//            }
//        }

//        btnContinueWithEmail.setOnClickListener {
//            CoroutineScope(Dispatchers.Main).launch {
//                Navigation.findNavController(it)
//                    .navigate(R.id.action_splashScreen1_to_signupEnterEmail)
//            }
//        }
    }

//    private fun googleSignIn() {
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
//        mAuth = FirebaseAuth.getInstance()
//    }

    private fun signInMethod() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            val exception = task.exception

            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            firebaseAuthWithGoogle(task)


//            if (task.isSuccessful) {
//                try {
//                    val account = task.getResult(ApiException::class.java)!!
//                    Log.d("SignInTag", "firebaseAuthWithGoogle:" + account.id)
//                    firebaseAuthWithGoogle(account.idToken!!)
//                } catch (e: ApiException) {
//                    // Google Sign In failed, update UI appropriately
//                    Log.w("SignInTag", "Google sign in failed", e)
//                }
//            } else {
////                Log.d("SignInTag", "Google sign in failed", "adlkcv")
//            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: Task<GoogleSignInAccount>) {
        try {
            accout = idToken.getResult(ApiException::class.java)
            acct = GoogleSignIn.getLastSignedInAccount(requireContext())

            if (acct != null) {
//                val credential = GoogleAuthProvider.getCredential(idToken.toString(), null)
//                mAuth.signInWithCredential(credential)
//                    .addOnCompleteListener(requireActivity()) { task ->
//                        if (task.isSuccessful) {
//                            view?.let {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_splashScreen1_to_fingerPrintVerification)
//                            }
//                        } else {
//                            Toast.makeText(context, "Error : ${task.exception}", Toast.LENGTH_SHORT).show()
//                        }
//                    }
            }
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(context, "Error : ${e.message}", Toast.LENGTH_SHORT).show()

        }
    }
}
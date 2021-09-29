package com.example.groww.loginSignup

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Loading : Fragment(R.layout.fragment_loading) {

    var handler: Handler? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            handler = Handler()
            handler!!.postDelayed({
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_loading_to_splashScreen1)
            },2000)
        }
    }
}
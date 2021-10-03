package com.example.groww.ui.addMoney

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.groww.R
import com.example.groww.ui.MainActivity
import com.example.groww.ui.loginSignup.LoginSplashScreenActivity
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_buy_share.*

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {

    val viewModelGrow: ViewModelGrow by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        viewModelGrow.getUserBalance().observe(this, Observer {
            if (it != null) {
                userBalanceProfile.text = it.addMoney.toString()
            } else userBalanceProfile.text = "0.00"
        })

        addMoneyProfile.setOnClickListener {
            val intent = Intent(this,AddMoney::class.java)
            startActivity(intent)
        }

        tvLogOut.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

}
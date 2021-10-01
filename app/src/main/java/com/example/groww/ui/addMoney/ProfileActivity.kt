package com.example.groww.ui.addMoney

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.groww.R
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_profile.*

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {

    val viewModelGrow: ViewModelGrow by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        viewModelGrow.getUserBalance().observe(this, Observer {
            if (it != null) {
                userBalanceProfile.text = it.toString()
            } else userBalanceProfile.text = "0.00"
        })
    }
}
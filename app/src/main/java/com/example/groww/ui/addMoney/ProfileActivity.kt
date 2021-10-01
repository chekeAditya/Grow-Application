package com.example.groww.ui.addMoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groww.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}
package com.example.groww.ui.addMoney.Explore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groww.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setPagerAdapter()
    }

    private fun setPagerAdapter() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPagerHome.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayoutHome,viewPagerHome){
            tab,position->when(position){
                0->{
                    tab.text = "Explore"
                }
            1-> tab.text = "DashBoard"
            }
        }.attach()
    }
}
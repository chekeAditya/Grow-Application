package com.example.groww.ui.mutualFunds

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.groww.R
import com.example.groww.ui.mutualFunds.adapter.ViewPagetAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_mutual_fund_base.*

class MutualFundBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mutual_fund_base)

        var adapter = ViewPagetAdapter(
            supportFragmentManager,
            lifecycle
        )
        viewPager.adapter = adapter

        TabLayoutMediator(
            tab_layout,
            viewPager
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Explore"
                    tab_layout.setSelectedTabIndicatorColor(Color.parseColor("#00D09C"))
                    tab_layout.setTabTextColors(Color.parseColor("#44465B"),Color.parseColor("#00D09C"))
                }
                1 -> {
                    tab.text = "Dashboard"
                    tab_layout.setSelectedTabIndicatorColor(Color.parseColor("#00D09C"))
                    tab_layout.setTabTextColors(Color.parseColor("#44465B"),Color.parseColor("#00D09C"))
                }
            }
        }.attach()
    }
}
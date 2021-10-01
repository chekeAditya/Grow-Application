package com.example.groww.ui.addMoney.explore

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.groww.ui.addMoney.explore.fragments.DashBoard
import com.example.groww.ui.addMoney.explore.fragments.Explore

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       when(position){
           0 ->return Explore()
           1 ->return DashBoard()
       }
        return Explore()
    }
}
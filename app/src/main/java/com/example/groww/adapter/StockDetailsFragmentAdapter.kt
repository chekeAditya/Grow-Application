package com.example.groww.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.groww.ui.search.StockDetailsEventsFragment
import com.example.groww.ui.search.StockDetailsNewsFragment
import com.example.groww.ui.search.StockDetailsOverviewFragment

class StockDetailsFragmentAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position){
            0 -> return StockDetailsOverviewFragment()
            1 -> return StockDetailsNewsFragment()
            2 -> return StockDetailsEventsFragment()
        }
        return StockDetailsOverviewFragment()
    }
}
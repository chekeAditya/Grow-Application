package com.example.groww.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.groww.R
import com.example.groww.search.adapter.StockDetailsFragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_stock_details.*

class StockDetailsFragment : Fragment(R.layout.fragment_stock_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFragmentViewPager()

    }

    private fun setupFragmentViewPager() {
        val stockDetailsFragmentAdapter = StockDetailsFragmentAdapter(childFragmentManager,lifecycle)
        stockDetailsViewPager.adapter =stockDetailsFragmentAdapter
            TabLayoutMediator(stockDetailsTabLayout,stockDetailsViewPager){ tab, position ->
                when(position){
                    0 -> tab.text = "Overview"
                    1 -> tab.text = "News"
                    2 -> tab.text = "Events"
                }
            }.attach()
    }

}
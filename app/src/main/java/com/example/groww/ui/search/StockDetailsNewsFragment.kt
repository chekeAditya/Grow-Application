package com.example.groww.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groww.R
import com.example.groww.ui.search.adapter.NewsAndEventsAdapter
import kotlinx.android.synthetic.main.fragment_stock_details_events.*
import kotlinx.android.synthetic.main.fragment_stock_details_news.*

class StockDetailsNewsFragment : Fragment(R.layout.fragment_stock_details_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()

    }

    private fun setRecyclerView() {
        val newsAndEventsAdapter = NewsAndEventsAdapter(0)
        newsRecyclerView.adapter = newsAndEventsAdapter
        newsRecyclerView.layoutManager = LinearLayoutManager(context)
    }

}
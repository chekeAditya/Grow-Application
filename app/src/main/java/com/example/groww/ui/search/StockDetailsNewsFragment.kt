package com.example.groww.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groww.R
import com.example.groww.adapter.NewsAndEventsAdapter
import com.example.groww.remote.responses.NewsAndEventsAPI
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_stock_details_news.*

@AndroidEntryPoint
class StockDetailsNewsFragment : Fragment(R.layout.fragment_stock_details_news) {

    private val viewModelGrow: ViewModelGrow by viewModels()

    val newsAndEventsAPIList = mutableListOf<NewsAndEventsAPI>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelGrow.getNewsResponseFromApi().observe(viewLifecycleOwner, Observer {
            newsAndEventsAPIList.clear()
            newsAndEventsAPIList.addAll(it)
            setRecyclerView()
        })

    }

    private fun setRecyclerView() {
        val newsAndEventsAdapter = NewsAndEventsAdapter(newsAndEventsAPIList,0)
        newsRecyclerView.adapter = newsAndEventsAdapter
        newsRecyclerView.layoutManager = LinearLayoutManager(context)
    }

}
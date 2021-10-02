package com.example.groww.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import com.example.groww.ui.search.adapter.FirstStockOverviewAdapter
import com.example.groww.ui.search.adapter.SecondStockOverviewAdapter
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_stock_details_overview.*

@AndroidEntryPoint
class StockDetailsOverviewFragment : Fragment(R.layout.fragment_stock_details_overview) {

    private val viewModel: ViewModelGrow by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerViews()

    }

    private fun setRecyclerViews() {
        viewModel.getDataFromDB().observe(viewLifecycleOwner, Observer {
            val newList = mutableListOf<StockAndMfApi>()
            for(i in 0..4)
                newList.add(it[i])
            firstSimilarStocksRecyclerView.adapter = FirstStockOverviewAdapter(newList)
            firstSimilarStocksRecyclerView.layoutManager = LinearLayoutManager(context)
            secondSimilarStocksRecyclerView.adapter = SecondStockOverviewAdapter(newList)
            secondSimilarStocksRecyclerView.layoutManager = LinearLayoutManager(context,
                RecyclerView.HORIZONTAL,false)
        })
    }

}
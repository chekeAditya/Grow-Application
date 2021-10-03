package com.example.groww.ui.addMoney.explore.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groww.R
import com.example.groww.adapter.DashboardAdapter
import com.example.groww.adapter.NewsAndEventsAdapter
import com.example.groww.adapter.SecondStockOverviewAdapter
import com.example.groww.remote.local.DashboardModel
import com.example.groww.remote.responses.NewsAndEventsAPI
import com.example.groww.remote.responses.StockAndMfApi
import com.example.groww.ui.addMoney.AddMoney
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dash_board.*
import kotlinx.android.synthetic.main.fragment_explore_abhi.*

@AndroidEntryPoint
class Explore : Fragment(R.layout.fragment_explore_abhi) {

    val viewModelGrow: ViewModelGrow by viewModels()
    private lateinit var secondStockOverviewAdapter: SecondStockOverviewAdapter
    private lateinit var newsAndEventsAdapter: NewsAndEventsAdapter
    var newsAndEventsAPIList = mutableListOf<NewsAndEventsAPI>()
    private val stockAndMfApiList = mutableListOf<StockAndMfApi>()
    lateinit var dashboardAdapter: DashboardAdapter
    private var dashboardModelList = mutableListOf<DashboardModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        addMoneyExplore.setOnClickListener {
            val intent = Intent(activity, AddMoney::class.java)
            startActivity(intent)
        }

        viewModelGrow.getUserBalance().observe(viewLifecycleOwner, Observer {
            if (it == null || it.addMoney < 1) {
                rlAddMoneyLayout.visibility = View.VISIBLE
            } else {
                rlAddMoneyLayout.visibility = View.GONE
            }
        })

        apiCallingTopGainers()
        apiCallingForStockNews()
        apiCallingWatchList()

        viewModelGrow.getDataFromDB().observe(viewLifecycleOwner, Observer {
            stockAndMfApiList.clear()
            stockAndMfApiList.addAll(it)
            secondStockOverviewAdapter.notifyDataSetChanged()

        })
        viewModelGrow.getDataFromDB()

        viewModelGrow.getNewsResponseFromApi().observe(viewLifecycleOwner, Observer {
            newsAndEventsAPIList.clear()
            newsAndEventsAPIList.addAll(it)
            newsAndEventsAdapter.notifyDataSetChanged()
        })
        viewModelGrow.getDataFromAPI()

        viewModelGrow.getDataINDashboard().observe(viewLifecycleOwner, Observer {
            dashboardModelList.clear()
            dashboardModelList.addAll(it)
            dashboardAdapter.notifyDataSetChanged()
        })
        viewModelGrow.getDataINDashboard()
    }

    private fun apiCallingWatchList() {
        dashboardAdapter = DashboardAdapter(requireContext(), dashboardModelList)
        topWatchlistExplore.layoutManager = LinearLayoutManager(requireContext())
        topWatchlistExplore.adapter = dashboardAdapter
    }

    private fun apiCallingForStockNews() {
        newsAndEventsAdapter = NewsAndEventsAdapter(newsAndEventsAPIList, 0)
        topNewsExplore.layoutManager = LinearLayoutManager(requireContext())
        topNewsExplore.adapter = newsAndEventsAdapter
    }

    private fun apiCallingTopGainers() {
        secondStockOverviewAdapter = SecondStockOverviewAdapter(stockAndMfApiList)
        topGainersExplore.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        topGainersExplore.adapter = secondStockOverviewAdapter
    }
}
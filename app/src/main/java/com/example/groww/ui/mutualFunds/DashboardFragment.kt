package com.example.groww.ui.mutualFunds

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groww.R
import com.example.groww.adapter.DashboardAdapter
import com.example.groww.remote.local.DashboardModel
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dash_board.rvShowedPurchacedStock
import kotlinx.android.synthetic.main.fragment_dashboard.*

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModelGrow: ViewModelGrow by viewModels()
    lateinit var dashboardAdapter: DashboardAdapter
    private var dashboardModelList = mutableListOf<DashboardModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dashboardAdapter = DashboardAdapter(requireContext(), dashboardModelList)
        rvShowedPurchacedStock.layoutManager = LinearLayoutManager(requireContext())
        rvShowedPurchacedStock.adapter = dashboardAdapter


        viewModelGrow.getDataINDashboard().observe(viewLifecycleOwner, Observer {
            dashboardModelList.clear()
            dashboardModelList.addAll(it)
            dashboardAdapter.notifyDataSetChanged()
            showVisibility()
        }
        )
        viewModelGrow.getDataINDashboard()
    }

    private fun showVisibility() {
        if (dashboardModelList.size == 0) {
            llShowWhenItsEmpty1.visibility = View.VISIBLE
            rlShowWhenFull1.visibility = View.GONE
        } else {
            llShowWhenItsEmpty1.visibility = View.GONE
            rlShowWhenFull1.visibility = View.VISIBLE
            calcutateData()
        }
    }

    private fun calcutateData() {
        var current = 0.00;
        var totalReturns = 0.00;
        var invested = 0.00;
        for (i in dashboardModelList) {
            current = (current + (i.stockPrice * i.stockQuantity) + 1.36 / 100)
            invested += (i.stockPrice * i.stockQuantity)
            totalReturns += (current - invested)
        }

        tvInvestedAmount.text = String.format("%.1f","₹ $invested")
        currentMoneyInDashBoard1.text = String.format("%.1f","₹ $current")
        totalReturns1.text = String.format("%.1f","₹ $totalReturns")
    }

}
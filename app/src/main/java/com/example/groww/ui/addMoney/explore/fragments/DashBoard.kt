package com.example.groww.ui.addMoney.explore.fragments

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
import kotlinx.android.synthetic.main.fragment_dash_board.*

@AndroidEntryPoint
class DashBoard : Fragment(R.layout.fragment_dash_board) {

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
            settingVisibility()

        })
        viewModelGrow.getDataINDashboard()
    }

    private fun settingVisibility() {
        if (dashboardModelList.size == 0) {
            llShowWhenItsEmpty.visibility = View.VISIBLE
            rlShowWhenFull.visibility = View.GONE
        } else {
            llShowWhenItsEmpty.visibility = View.GONE
            rlShowWhenFull.visibility = View.VISIBLE
            calculateData()
        }
    }

    private fun calculateData() {
        var current2 = 0.00;
        var totalReturns2 = 0.00;
        var invested2 = 0.00;

        viewModelGrow.getCurrentPriceSum().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                current2 = it + (it * (1.36 / 100))
                invested2 = it
                totalReturns2 = current2 - invested2


                tvInvestedAmount2.text = String.format("₹ %.1f", invested2)
                tvcurrentMoneyInDashBoard2.text = String.format("₹ %.1f", current2)
                tvtotalReturns2.text = String.format("₹ %.1f", totalReturns2)
            }
        })
    }

}
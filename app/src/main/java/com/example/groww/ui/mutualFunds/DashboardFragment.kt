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
import kotlinx.android.synthetic.main.fragment_dash_board.*

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
            if (dashboardModelList.size == 0) {
                llShowWhenItsEmpty.visibility = View.VISIBLE
                rlShowWhenFull.visibility  = View.GONE
            }else{
                llShowWhenItsEmpty.visibility = View.GONE
                rlShowWhenFull.visibility = View.VISIBLE
            }
        })
        viewModelGrow.getDataINDashboard()
    }

}
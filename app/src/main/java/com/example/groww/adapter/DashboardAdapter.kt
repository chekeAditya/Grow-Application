package com.example.groww.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groww.R
import com.example.groww.remote.local.DashboardModel
import kotlinx.android.synthetic.main.item_layout_dashboard_buyedstock.view.*

class DashboardAdapter(
    private val context: Context,
    private val dashboardModelList: List<DashboardModel>
) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    //viewHolder
    class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(dashboardModel: DashboardModel) {
            itemView.apply {
                tvCompanyNameDashboard.text = dashboardModel.stockName
                tvCompanyShareQuantityDashboard.text = "${dashboardModel.stockQuantity.toString()} shares"
                tvStockCurrentPriceDashboard.text = "₹ ${dashboardModel.stockPrice}"
                val returnMoney =
                    dashboardModel.stockPrice + dashboardModel.stockPrice * (1.35 / 100)
                tvStockReturnsPriceDashboard.text = String.format("%.2f", returnMoney)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_layout_dashboard_buyedstock, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val dashboardModel = dashboardModelList[position]
        holder.setData(dashboardModel)
    }

    override fun getItemCount(): Int {
        return dashboardModelList.size
    }


}
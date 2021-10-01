package com.example.groww.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.android.synthetic.main.item_layout_quickaccess.view.*

class ExploreQuickAccessAdapter(
    val context: Context,
    val stockAndMfApiList: List<StockAndMfApi>
) : RecyclerView.Adapter<ExploreQuickAccessAdapter.ExploreQuickAccessViewHolder>() {

    //viewHolder
    class ExploreQuickAccessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(stockAndMfApi: StockAndMfApi) {
            itemView.apply {
                item_Pf_tv_StockLive.text = stockAndMfApi.qaHeading
                item_Pf_tv_StockLiveDesc.text = stockAndMfApi.qaDesc
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExploreQuickAccessViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_layout_quickaccess, parent, false)
        return ExploreQuickAccessViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreQuickAccessViewHolder, position: Int) {
        val stockAndMfApi = stockAndMfApiList[position]
        holder.setData(stockAndMfApi)
    }

    override fun getItemCount(): Int {
        return stockAndMfApiList.size
    }
}
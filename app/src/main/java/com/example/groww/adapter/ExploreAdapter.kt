package com.example.groww.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.android.synthetic.main.item_layout_popularfunds.view.*

class ExploreAdapter(
    private val context: Context,
    private val stockAndMfApiList: List<StockAndMfApi>
) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {


    //viewHolder
    class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(stockAndMfApi: StockAndMfApi) {
            itemView.apply {
                Glide.with(item_Pf_Iv_StockLogo).load(stockAndMfApi.mfLogo)
                    .into(item_Pf_Iv_StockLogo)
                item_Pf_tv_StockName.text = stockAndMfApi.mfName
                item_pf_stockSector.text = stockAndMfApi.mfSector
                item_Pf_tv_StockProfitPercent.text = stockAndMfApi.mfPercentage
                item_pf_stockReturns.text = stockAndMfApi.mfYearReturn
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_layout_popularfunds, parent, false)
        return ExploreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val stockAndMfApi = stockAndMfApiList[position]
        holder.setData(stockAndMfApi)
    }

    override fun getItemCount(): Int {
        return stockAndMfApiList.size
    }
}
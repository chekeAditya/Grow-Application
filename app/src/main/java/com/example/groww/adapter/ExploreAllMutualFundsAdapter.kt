package com.example.groww.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.android.synthetic.main.item_layout_all_mutual_funds.view.*

class ExploreAllMutualFundsAdapter(
    private val context: Context,
    private val stockAndMfApi: List<StockAndMfApi>
) : RecyclerView.Adapter<ExploreAllMutualFundsAdapter.ExploreAllMutualFundViewHolder>() {


    class ExploreAllMutualFundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(stockAndMfApi: StockAndMfApi){
            itemView.apply {
                Glide.with(item_mf_Iv_StockLogo).load(stockAndMfApi.mfLogo).into(item_mf_Iv_StockLogo)
                item_mf_tv_StockName.text = stockAndMfApi.mfName
                item_mf_tv_StockProfitPercent.text = stockAndMfApi.mfPercentage
                item_mf_stockSector.text = stockAndMfApi.mfSector
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExploreAllMutualFundViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout_all_mutual_funds,parent,false)
        return ExploreAllMutualFundViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreAllMutualFundViewHolder, position: Int) {
        val stockAndMfApi = stockAndMfApi[position]
        holder.setData(stockAndMfApi)
    }

    override fun getItemCount(): Int {
        return stockAndMfApi.size
    }
}
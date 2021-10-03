package com.example.groww.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.android.synthetic.main.stocks_similar_second_item_view.view.*

class SecondStockOverviewAdapter(private val list: List<StockAndMfApi>): RecyclerView.Adapter<SecondStockOverviewAdapter.SecondStockOverviewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SecondStockOverviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.
        stocks_similar_second_item_view,parent,false)
        return SecondStockOverviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondStockOverviewViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SecondStockOverviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun setData(stockAndMfApi: StockAndMfApi){
            itemView.apply {
                Glide.with(SimilarStockSecondImage).load(stockAndMfApi.companyImage).
                into(SimilarStockSecondImage)
                SimilarStockSecondName.text = stockAndMfApi.companySymbol
                SimilarStockSecondPrice.text = "₹${stockAndMfApi.companyCurrentPrice}"
                SimilarStockSecondPercent.text = "${stockAndMfApi.priceGain} (${stockAndMfApi.percentGain})"
            }
        }
    }

}
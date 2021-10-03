package com.example.groww.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.android.synthetic.main.item_list_layout.view.*
import kotlinx.android.synthetic.main.stocks_similar_second_item_view.view.*

class TopLoserAdapter(private val list: MutableList<StockAndMfApi>): RecyclerView.Adapter<TopLoserAdapter.TopLoserViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopLoserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.
        item_list_layout,parent,false)
        return TopLoserViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopLoserViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class TopLoserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun setData(stockAndMfApi: StockAndMfApi){
            itemView.apply {
                Glide.with(logoLoser).load(stockAndMfApi.companyImage).
                into(logoLoser)
                companySymbolLoser.text = stockAndMfApi.companySymbol
                currentPriceLoser.text = "₹${stockAndMfApi.companyCurrentPrice}"
                priceGainLoser.text = "${stockAndMfApi.priceGain} (${stockAndMfApi.percentGain})"
            }
        }
    }

}
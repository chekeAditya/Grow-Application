package com.example.groww.ui.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.android.synthetic.main.stocks_similar_first_item_view.view.*

class FirstStockOverviewAdapter(private val list: List<StockAndMfApi>): RecyclerView.Adapter<FirstStockOverviewAdapter.
FirstStockOverviewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstStockOverviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.
        stocks_similar_first_item_view,parent,false)
        return FirstStockOverviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstStockOverviewViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FirstStockOverviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun setData(stockAndMfApi: StockAndMfApi){
            itemView.apply {
                similarStockFirstName.text = stockAndMfApi.companyName
                similarStockFirstPrice.text = "₹${stockAndMfApi.companyCurrentPrice}"
                similarStockFirstPercent.text = stockAndMfApi.percentGain
            }
        }
    }

}
package com.example.groww.ui.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.android.synthetic.main.search_item_view.view.*

class SearchAllAdapter(private val list: List<StockAndMfApi>,private val searchTrue: Boolean,
                       private val onSearchAllItemClickListener: OnSearchAllItemClickListener):
    RecyclerView.Adapter<SearchAllAdapter.SearchAllViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAllViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item_view,
            parent,false)
        return SearchAllViewHolder(view,onSearchAllItemClickListener)
    }

    override fun onBindViewHolder(holder: SearchAllViewHolder, position: Int) {
        holder.setData(list[position],searchTrue)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SearchAllViewHolder(itemView: View,private val onSearchAllItemClickListener:
    OnSearchAllItemClickListener) : RecyclerView.ViewHolder(itemView){

        fun setData(stockAndMfApi: StockAndMfApi,searchTrue: Boolean){
            if (!searchTrue) itemView.ivSearch.setImageResource(R.drawable.history)
            itemView.tvShareName.text = stockAndMfApi.companyName
            itemView.tvShareShortName.text = stockAndMfApi.companySymbol

            itemView.searchAllItemView.setOnClickListener {
                onSearchAllItemClickListener.onClickOfSearchAllItem(stockAndMfApi)
            }
        }

    }

}
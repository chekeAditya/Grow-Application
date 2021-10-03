package com.example.groww.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groww.R
import com.example.groww.remote.responses.NewsAndEventsAPI
import kotlinx.android.synthetic.main.news_item_view.view.*

class NewsAndEventsAdapter(
    private val listNewsAndEventsAPIList: MutableList<NewsAndEventsAPI>,
    private val itemViewType: Int
) :
    RecyclerView.Adapter<NewsAndEventsAdapter.NewsAndEventsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAndEventsViewHolder {
        return if (itemViewType == 0) {
            NewsAndEventsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.news_item_view, parent, false)
            )
        } else {
            NewsAndEventsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.event_item_view, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: NewsAndEventsViewHolder, position: Int) {
        if (itemViewType == 0) {
            val newsAndEventsAPI = listNewsAndEventsAPIList[position]
            holder.setData(newsAndEventsAPI)
        }
    }

    override fun getItemCount(): Int {
        return if (itemViewType == 0)
            listNewsAndEventsAPIList.size
        else 10
    }

    class NewsAndEventsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(newsAndEventsAPI: NewsAndEventsAPI){
            itemView.apply {
                tvNewsHeading.text = newsAndEventsAPI.newsHead
                tvNewsDesc.text = newsAndEventsAPI.news
            }
        }
    }

}
package com.example.groww.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groww.R

class NewsAndEventsAdapter(private val itemViewType: Int): RecyclerView.Adapter<NewsAndEventsAdapter.NewsAndEventsViewHolder>() {

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
    }

    override fun getItemCount(): Int {
        return 10
    }

    class NewsAndEventsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

}
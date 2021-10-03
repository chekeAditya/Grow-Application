package com.example.groww.remote.responses


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "grow_news_database")
data class NewsAndEventsAPI(
    @ColumnInfo(name = "news")
    @SerializedName("news")
    val news: String,
    @ColumnInfo(name = "news_head")
    @SerializedName("news_head")
    val newsHead: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
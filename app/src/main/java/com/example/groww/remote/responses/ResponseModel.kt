package com.example.groww.remote.responses


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("newsAndEventsAPI")
    val newsAndEventsAPI: List<NewsAndEventsAPI>,
    @SerializedName("stock and mf api")
    val stockAndMfApi: List<StockAndMfApi>
    )
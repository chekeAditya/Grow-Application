package com.example.groww.remote.responses.liveResponse


import com.google.gson.annotations.SerializedName

data class X20210929154600(
    @SerializedName("4. close")
    val close: String,
    @SerializedName("2. high")
    val high: String,
    @SerializedName("3. low")
    val low: String,
    @SerializedName("1. open")
    val `open`: String,
    @SerializedName("5. volume")
    val volume: String
)
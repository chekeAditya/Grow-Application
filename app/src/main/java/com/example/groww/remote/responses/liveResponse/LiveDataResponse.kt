package com.example.groww.remote.responses.liveResponse


import com.google.gson.annotations.SerializedName

data class LiveDataResponse(
    @SerializedName("Meta Data")
    val metaData: MetaData,
    @SerializedName("Time Series (1min)")
    val timeSeries1min: TimeSeries1min
)
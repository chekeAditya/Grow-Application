package com.example.groww.remote.responses.liveResponse


import com.google.gson.annotations.SerializedName

data class TimeSeries1min(
    @SerializedName("2021-09-29 15:45:00")
    val x20210929154500: X20210929154500,
    @SerializedName("2021-09-29 15:46:00")
    val x20210929154600: X20210929154600,
    @SerializedName("2021-09-29 15:47:00")
    val x20210929154700: X20210929154700,
    @SerializedName("2021-09-29 15:48:00")
    val x20210929154800: X20210929154800
)
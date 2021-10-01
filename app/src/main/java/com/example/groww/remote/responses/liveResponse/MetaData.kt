package com.example.groww.remote.responses.liveResponse


import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("1. Information")
    val information: String,
    @SerializedName("4. Interval")
    val interval: String,
    @SerializedName("3. Last Refreshed")
    val lastRefreshed: String,
    @SerializedName("5. Output Size")
    val outputSize: String,
    @SerializedName("2. Symbol")
    val symbol: String,
    @SerializedName("6. Time Zone")
    val timeZone: String
)
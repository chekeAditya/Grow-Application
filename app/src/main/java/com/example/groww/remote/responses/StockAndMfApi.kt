package com.example.groww.remote.responses


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "grow_explore_fragment")
data class StockAndMfApi(

    @ColumnInfo(name = "company_current_price")
    @SerializedName("company_current_price")
    val companyCurrentPrice: String,

    @ColumnInfo(name = "company_image")
    @SerializedName("company_image")
    val companyImage: String,

    @ColumnInfo(name = "company_name")
    @SerializedName("company_name")
    val companyName: String,

    @ColumnInfo(name = "company_symbol")
    @SerializedName("company_symbol")
    val companySymbol: String,

    @ColumnInfo(name = "mf_logo")
    @SerializedName("mf_logo")
    val mfLogo: String,

    @ColumnInfo(name = "mf_name")
    @SerializedName("mf_name")
    val mfName: String,

    @ColumnInfo(name = "mf_percentage")
    @SerializedName("mf_percentage")
    val mfPercentage: String,

    @ColumnInfo(name = "mf_sector")
    @SerializedName("mf_sector")
    val mfSector: String,

    @ColumnInfo(name = "mf_year_return")
    @SerializedName("mf_year_return")
    val mfYearReturn: String,

    @ColumnInfo(name = "percent_gain")
    @SerializedName("percent_gain")
    val percentGain: String,

    @ColumnInfo(name = "percent_loss")
    @SerializedName("percent_loss")
    val percentLoss: String,

    @ColumnInfo(name = "price_gain")
    @SerializedName("price_gain")
    val priceGain: String,

    @ColumnInfo(name = "price_loss")
    @SerializedName("price_loss")
    val priceLoss: String,

    @ColumnInfo(name = "qa_desc")
    @SerializedName("qa_desc")
    val qaDesc: String,

    @ColumnInfo(name = "qa_heading")
    @SerializedName("qa_heading")
    val qaHeading: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int? = null
}
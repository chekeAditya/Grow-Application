package com.example.groww.remote.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_balance")
data class UserBalance(
    @ColumnInfo(name = "add_money")
    val addMoney: Double,

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null
)

@Entity(tableName = "boughtStock")
data class boughtStock(
    @PrimaryKey
    @ColumnInfo(name = "id") val id:Int? = null,

//    @ColumnInfo(name = "")

)
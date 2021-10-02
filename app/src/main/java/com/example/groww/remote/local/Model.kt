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

@Entity(tableName = "dashboard_stock")
data class DashboardModel(
    @ColumnInfo(name = "stockName")
    val stockName: String,
    @ColumnInfo(name = "stockPrice")
    val stockPrice: Double,
    @ColumnInfo(name = "stockQuantity")
    val stockQuantity: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
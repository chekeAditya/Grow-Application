package com.example.groww.remote.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.groww.remote.responses.StockAndMfApi

@Dao
interface GrowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDataFROMAPI(stockAndMfApi: List<StockAndMfApi>)

    @Query("select * from grow_explore_fragment")
    fun getResponseFromAPI(): LiveData<List<StockAndMfApi>>

    @Query("delete from grow_explore_fragment")
    fun deleteAllData()

}
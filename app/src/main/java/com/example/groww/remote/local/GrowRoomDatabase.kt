package com.example.groww.remote.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.groww.remote.responses.NewsAndEventsAPI
import com.example.groww.remote.responses.StockAndMfApi


@Database(entities = [StockAndMfApi::class,UserBalance::class,DashboardModel::class,NewsAndEventsAPI::class],
    version = 1)
abstract class GrowRoomDatabase : RoomDatabase() {

    abstract fun getResponseGrowDao(): GrowDao
/**
    companion object {
        private var INSTANCE: GrowRoomDatabase? = null

        fun getDatabaseObject(context: Context): GrowRoomDatabase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    GrowRoomDatabase::class.java,
                    "grow_db"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
    */
}
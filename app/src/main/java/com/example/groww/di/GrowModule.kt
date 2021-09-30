package com.example.groww.di

import android.content.Context
import androidx.room.Room
import com.example.groww.remote.APIClient
import com.example.groww.remote.local.GrowDao
import com.example.groww.remote.local.GrowRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GrowModule {

    private const val BASE_URL = "https://run.mocky.io/"

    @Provides
    fun provideAPISERVICE(): APIClient {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(APIClient::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): GrowRoomDatabase {
        val builder = Room.databaseBuilder(
            context, GrowRoomDatabase::class.java, "grow_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideTaskDAO(db: GrowRoomDatabase): GrowDao {
        return db.getResponseGrowDao()
    }

}
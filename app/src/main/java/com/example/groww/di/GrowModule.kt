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

    //URl :- https://gist.githubusercontent.com/chekeAditya/26a7978a5bdbf95f22751f77bf1f7055/raw/b8699d9587820b607f01deeeb8e4b1efdaa90238/gistfile1.txt
    //URL :- https://gist.githubusercontent.com/chekeAditya/26a7978a5bdbf95f22751f77bf1f7055/raw/b9633db9cc1de349c1b12e816ad697f04bf55ecc/gistfile1.txt
    private const val BASE_URL = "https://gist.githubusercontent.com/chekeAditya/26a7978a5bdbf95f22751f77bf1f7055/raw/b9633db9cc1de349c1b12e816ad697f04bf55ecc/"

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
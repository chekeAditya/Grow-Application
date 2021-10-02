package com.example.groww.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static final String BASE_URL = "https://gist.githubusercontent.com/chekeAditya/26a7978a5bdbf95f22751f77bf1f7055/raw/b8699d9587820b607f01deeeb8e4b1efdaa90238/";

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
    }
}
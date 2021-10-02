package com.example.groww.remote

import com.example.groww.remote.responses.ResponseModel
import retrofit2.http.GET

interface APIClient {


    @GET("gistfile1.txt")
    suspend fun getAPIResponse(): ResponseModel

}
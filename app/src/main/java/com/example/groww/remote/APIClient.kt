package com.example.groww.remote

import com.example.groww.remote.responses.ResponseModel
import retrofit2.http.GET

interface APIClient {


    @GET("v3/4a421942-2eea-4faa-bd9c-0cf36da0fcdc")
    suspend fun getAPIResponse(): ResponseModel

}
package com.example.groww.repopsitory

import androidx.lifecycle.LiveData
import com.example.groww.remote.APIClient
import com.example.groww.remote.Network
import com.example.groww.remote.Resource
import com.example.groww.remote.ResponseHandler
import com.example.groww.remote.local.GrowDao
import com.example.groww.remote.responses.ResponseModel
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(private val growDao: GrowDao,val api: APIClient) {


    /**
    private lateinit var responseHandler: ResponseHandler

    suspend fun getResponseFromAPI(): Resource<ResponseModel> {
        return try {
            val response = api.getAPIResponse()
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e)
        }
    }
    */

    fun getRemoteResponseFromAPI(){
        CoroutineScope(Dispatchers.IO).launch {
            saveToDB(api.getAPIResponse())
        }
    }

    fun saveToDB(responseModel: ResponseModel) {
        val listOfData = ArrayList<StockAndMfApi>()
        growDao.deleteAllData()
        listOfData.addAll(responseModel.stockAndMfApi)
        growDao.addDataFROMAPI(listOfData)
    }

    fun getAllDataFromDB():LiveData<List<StockAndMfApi>>{
        return growDao.getResponseFromAPI()
    }


}
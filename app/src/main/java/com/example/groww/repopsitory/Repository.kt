package com.example.groww.repopsitory

import androidx.lifecycle.LiveData
import com.example.groww.remote.APIClient
import com.example.groww.remote.local.DashboardModel
import com.example.groww.remote.local.GrowDao
import com.example.groww.remote.local.UserBalance
import com.example.groww.remote.responses.NewsAndEventsAPI
import com.example.groww.remote.responses.ResponseModel
import com.example.groww.remote.responses.StockAndMfApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(private val growDao: GrowDao, val api: APIClient) {


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

    fun getRemoteResponseFromAPI() {
        CoroutineScope(Dispatchers.IO).launch {
            saveToDB(api.getAPIResponse())
            saveNewsDataToDB(api.getAPIResponse())
        }
    }

    fun saveToDB(responseModel: ResponseModel) {
        val listOfData = ArrayList<StockAndMfApi>()
        growDao.deleteAllData()
        listOfData.addAll(responseModel.stockAndMfApi)
        growDao.addDataFROMAPI(listOfData)
    }

    fun getAllDataFromDB(): LiveData<List<StockAndMfApi>> {
        return growDao.getResponseFromAPI()
    }

    fun insertMoney(userBalance: UserBalance) {
        CoroutineScope(Dispatchers.IO).launch {
            growDao.insertMoney(userBalance)
        }
    }

    fun getMoney():LiveData<UserBalance>{
        return growDao.getUserMoney()
    }

    fun getParticularStock(id: Int): LiveData<StockAndMfApi>{
        return growDao.getParticularResponseFromAPI(id)
    }

    fun setDataInDashboard(dashboardModel: DashboardModel){
        CoroutineScope(Dispatchers.IO).launch {
            growDao.setDataInDashboard(dashboardModel)
        }
    }

    fun getDataForDashboard():LiveData<List<DashboardModel>>{
        return growDao.getDataForDashboard()
    }

    fun currentPriceSum():LiveData<Double>{
        return growDao.currentPriceSum()
    }

    fun saveNewsDataToDB(responseModel: ResponseModel) {
        val listOfNewsData = ArrayList<NewsAndEventsAPI>()
        growDao.deleteAllNewsData()
        listOfNewsData.addAll(responseModel.newsAndEventsAPI)
        growDao.addNewsDataFROMAPI(listOfNewsData)
    }

    fun getNewsResponseFromApi() :LiveData<List<NewsAndEventsAPI>>{
        return growDao.getNewsResponseFromAPI()
    }

}
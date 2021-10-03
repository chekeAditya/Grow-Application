package com.example.groww.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.groww.remote.local.DashboardModel
import com.example.groww.remote.local.UserBalance
import com.example.groww.remote.responses.NewsAndEventsAPI
import com.example.groww.remote.responses.StockAndMfApi
import com.example.groww.repopsitory.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ViewModelGrow @Inject constructor(val repo: Repository) : ViewModel() {

    /**
    fun fetchingResponse(): LiveData<Resource<ResponseModel>> {
    val livedata = liveData(Dispatchers.IO) {
    val result = repo.getResponseFromAPI()
    emit(result)
    }
    return livedata
    }
     */

    fun getDataFromDB(): LiveData<List<StockAndMfApi>> {
        return repo.getAllDataFromDB()
    }

    fun getDataFromAPI() {
        repo.getRemoteResponseFromAPI()
    }

    fun getUserBalance(): LiveData<UserBalance> {
        return repo.getMoney()
    }

    fun insertMoney(userBalance: UserBalance){
        repo.insertMoney(userBalance)
    }

    fun getParticularStock(id: Int): LiveData<StockAndMfApi>{
        return repo.getParticularStock(id)
    }

    fun setDataInDashboard(dashboardModel: DashboardModel){
        repo.setDataInDashboard(dashboardModel)
    }

    fun getDataINDashboard():LiveData<List<DashboardModel>>{
        return repo.getDataForDashboard()
    }

    fun getCurrentPriceSum():LiveData<Double>{
        return repo.currentPriceSum()
    }

    fun getNewsResponseFromApi():LiveData<List<NewsAndEventsAPI>>{
        return repo.getNewsResponseFromApi()
    }
}
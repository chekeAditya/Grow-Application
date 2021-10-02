package com.example.groww.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.groww.remote.local.Dashboard
import com.example.groww.remote.local.UserBalance
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
    }k

    fun getParticularStock(id: Int): LiveData<StockAndMfApi>{
        return repo.getParticularStock(id)
    }

    fun setDataInDashboard(dashboard: Dashboard){
        repo.setDataInDashboard(dashboard)
    }

    fun getDataINDashboard():LiveData<List<Dashboard>>{
        return repo.getDataForDashboard()
    }
}
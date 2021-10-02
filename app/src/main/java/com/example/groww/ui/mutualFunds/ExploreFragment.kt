package com.example.groww.ui.mutualFunds

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groww.R
import com.example.groww.adapter.ExploreAllMutualFundsAdapter
import com.example.groww.adapter.ExplorePopularFundAdapter
import com.example.groww.adapter.ExploreQuickAccessAdapter
import com.example.groww.remote.local.GrowDao
import com.example.groww.remote.local.GrowRoomDatabase
import com.example.groww.remote.responses.StockAndMfApi
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_explore.*

@AndroidEntryPoint
class ExploreFragment : Fragment(R.layout.fragment_explore) {

    lateinit var explorePopularFundAdapter: ExplorePopularFundAdapter
    lateinit var exploreQuickAccessAdapter: ExploreQuickAccessAdapter
    lateinit var exploreAllMutualFundAdapter: ExploreAllMutualFundsAdapter

    private var stockAndMfApi = mutableListOf<StockAndMfApi>()
     private val viewModelGrow: ViewModelGrow by viewModels()
    lateinit var growDao: GrowDao
    lateinit var growRoomDatabase: GrowRoomDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /**
        growRoomDatabase = GrowRoomDatabase.getDatabaseObject(requireContext())
        growDao = growRoomDatabase.getResponseGrowDao()

        val repo = Repository(growDao)
        val viewModelFactory = ViewModelFactory(repo)
        viewModelGrow = ViewModelProviders.of(this, viewModelFactory).get(ViewModelGrow::class.java)
        viewModelGrow.fetchingResponse().observe(viewLifecycleOwner, Observer {
            val response = it
            when(response.status){
                Status.SUCCESS -> {

                    stockAndMfApi = it.data?.stockAndMfApi!!

                    exploreAdapter = ExploreAdapter(requireContext(),stockAndMfApi)
                    rvPopularFunds.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                    rvPopularFunds.adapter = exploreAdapter
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Error in explore Frag", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING ->{
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }
            }
        })
         */

        //popular fund Adapter(horizontal scroll)
        explorePopularFundAdapter = ExplorePopularFundAdapter(requireContext(),stockAndMfApi)
        rvPopularFunds.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        rvPopularFunds.adapter = explorePopularFundAdapter

        //quick access adapter(horizontal Scroll)
        exploreQuickAccessAdapter = ExploreQuickAccessAdapter(requireContext(),stockAndMfApi)
        rvQuickAccess.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        rvQuickAccess.adapter = exploreQuickAccessAdapter

        //mutual fund adapter (vertical Scroll)
        exploreAllMutualFundAdapter = ExploreAllMutualFundsAdapter(requireContext(),stockAndMfApi)
        rvAllMutualFunds.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        rvAllMutualFunds.adapter = exploreAllMutualFundAdapter

        viewModelGrow.getDataFromDB().observe(viewLifecycleOwner, Observer {
            stockAndMfApi.clear()
            stockAndMfApi.addAll(it)
            explorePopularFundAdapter.notifyDataSetChanged()
            exploreQuickAccessAdapter.notifyDataSetChanged()
            exploreAllMutualFundAdapter.notifyDataSetChanged()

        })
        viewModelGrow.getDataFromAPI()
    }

}
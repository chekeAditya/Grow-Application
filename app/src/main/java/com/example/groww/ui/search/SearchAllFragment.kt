package com.example.groww.ui.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groww.R
import com.example.groww.remote.responses.StockAndMfApi
import com.example.groww.ui.addMoney.explore.HomeActivity
import com.example.groww.adapter.OnSearchAllItemClickListener
import com.example.groww.adapter.SearchAllAdapter
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search_all.*

@AndroidEntryPoint
class SearchAllFragment : Fragment(R.layout.fragment_search_all), OnSearchAllItemClickListener {

    private val viewModel: ViewModelGrow by viewModels()
    private val searchList: MutableList<StockAndMfApi> = mutableListOf()
    private lateinit var searchAllAdapter: SearchAllAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(false,searchList)

        viewModel.getDataFromDB().observe(viewLifecycleOwner, Observer {
            searchList.clear()
            searchList.addAll(it)
            searchAllAdapter.notifyDataSetChanged()
        })

        ibBack.setOnClickListener {
            startActivity(Intent(context,HomeActivity::class.java))
        }

        etSearchAll.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (etSearchAll.text.toString().trim().isNotEmpty()){
                    val newSearchList = mutableListOf<StockAndMfApi>()
                    for (i in searchList){
                        if (i.companyName.substring(0,etSearchAll.text.toString().length).equals(
                            etSearchAll.text.toString(),true))
                                newSearchList.add(i)
                    }
                    setRecyclerView(true,newSearchList)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

    }

    private fun setRecyclerView(searchTrue: Boolean,list:List<StockAndMfApi>) {
        searchAllAdapter = SearchAllAdapter(list,searchTrue,this)
        searchAllRecyclerView.adapter = searchAllAdapter
        searchAllRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onClickOfSearchAllItem(stockAndMfApi: StockAndMfApi) {
        val navController = Navigation.findNavController(requireView())
        val bundle = Bundle()
        bundle.putInt("id",stockAndMfApi.id!!)
        navController.navigate(R.id.action_searchAllFragment_to_stockDetailsFragment,bundle)
    }

}
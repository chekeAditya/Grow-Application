package com.example.groww.ui.buy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.groww.R
import com.example.groww.remote.local.DashboardModel
import com.example.groww.remote.local.UserBalance
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_buy_share.*

@AndroidEntryPoint
class BuyShareFragment : Fragment(R.layout.fragment_buy_share) {

    private val viewModel: ViewModelGrow by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(requireView())
        val id = arguments?.getInt("id")

        setData(id)

        etInputQty.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(etInputQty.text.toString().isNotEmpty())
                    btnShareBuy.setBackgroundResource(R.drawable.bg_buy)
                else btnShareBuy.setBackgroundResource(R.drawable.bg_buy_unselected)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        btnShareBuy.setOnClickListener {
            if(etInputQty.text.toString().isNotEmpty()){
                val tvBalanceAmount = tvBalanceAmount.text.toString()
                val tvSharePrice = tvBuyShareAmount.text.toString()
                val inputAmount = etInputQty.text.toString().toDouble()
                val sharePrice = tvSharePrice.substring(2,tvSharePrice.length).toDouble()
                val balanceAmount = tvBalanceAmount.substring(1,tvBalanceAmount.length).toDouble()

                if (inputAmount*sharePrice > balanceAmount || inputAmount == 0.0) {
                    Toast.makeText(context, "Insufficient amount", Toast.LENGTH_SHORT).show()
                }
                else{
                    val userBalance = UserBalance(id = 1,addMoney = balanceAmount-(inputAmount*sharePrice))
                    viewModel.insertMoney(userBalance)

                    val stockName = tvBuyShareName.text.toString().substring(4,
                        tvBuyShareName.text.toString().length)
                    val dashboard = DashboardModel(stockName,inputAmount.toInt()*sharePrice,inputAmount.toInt())
                    viewModel.setDataInDashboard(dashboard)

                    val bundle = Bundle()
                    bundle.putString("company",tvBuyShareName.text.toString())
                    bundle.putString("share",etInputQty.text.toString())
                    navController.navigate(R.id.action_buyShareFragment_to_buyShareSuccessFragment,bundle)
                }
            }
        }

        ivBack.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id",id!!)
            navController.navigate(R.id.action_buyShareFragment_to_stockDetailsFragment,bundle)
        }
    }

    private fun setData(id: Int?) {
        viewModel.getParticularStock(id!!).observe(viewLifecycleOwner, Observer {
            tvBuyShareName.text = "Buy ${it.companyName}"
            tvBuySharePrice.text = "₹${it.companyCurrentPrice}"
            tvBuyShareAmount.text = "₹ ${it.companyCurrentPrice}"
        })
        viewModel.getUserBalance().observe(viewLifecycleOwner, Observer {
            if(it != null)
            tvBalanceAmount.text = "₹${it.addMoney}"
        })
    }

}
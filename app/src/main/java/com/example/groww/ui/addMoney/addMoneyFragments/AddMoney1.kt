package com.example.groww.ui.addMoney.addMoneyFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.groww.R
import com.example.groww.remote.local.UserBalance
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_money1.*

@AndroidEntryPoint
class AddMoney1 : Fragment(R.layout.fragment_add_money1){

    val viewModelGrow: ViewModelGrow by viewModels()

    var addingMoney = 0.0
    var userBalance = 0.0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        llPaymentOptions.setOnClickListener {
            val passEmail = AddMoney1Directions.actionAddMoney1ToAddMoney22(etMoneyAddAmt.text.toString())
            Navigation.findNavController(it)
                .navigate(passEmail)
        }


        edit_1000.setOnClickListener {
            var addThousand = etMoneyAddAmt.text.toString().toInt()+1000
            etMoneyAddAmt.setText("$addThousand")
        }


        viewModelGrow.getUserBalance().observe(viewLifecycleOwner, Observer {
            if (it != null){
                userBalance = it.addMoney
            }else{
                userBalance = 0.0
            }
        })

        addMoney1Btn.setOnClickListener {




             addingMoney = etMoneyAddAmt.text.toString().toDouble()

            val passEmail = AddMoney1Directions.actionAddMoney1ToAddMoney3(etMoneyAddAmt.text.toString())
            Navigation.findNavController(requireView())
                .navigate(passEmail)
            val userModel = UserBalance(id = 1, addMoney = (addingMoney+userBalance))
            viewModelGrow.insertMoney(userModel)



        }

        viewModelGrow.getUserBalance().observe(viewLifecycleOwner, Observer {
            if (it != null){
                tvBalanceInAddMoneyFragment.text = "₹${it.addMoney}"
            }else{
                tvBalanceInAddMoneyFragment.text = "₹0.00"
            }
        })
    }


}
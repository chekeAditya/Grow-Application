package com.example.groww.ui.addMoney.addMoneyFragments

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
class AddMoney1 : Fragment(R.layout.fragment_add_money1) {

    val viewModelGrow: ViewModelGrow by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        llPaymentOptions.setOnClickListener {
            val passEmail = AddMoney1Directions.actionAddMoney1ToAddMoney22(etMoneyAddAmt.text.toString())
            Navigation.findNavController(it)
                .navigate(passEmail)
        }

        edit_1000.setOnClickListener {
            etMoneyAddAmt.setText("1000")
        }



        addMoney1Btn.setOnClickListener {

            val passEmail = AddMoney1Directions.actionAddMoney1ToAddMoney3(etMoneyAddAmt.text.toString())
            Navigation.findNavController(it)
                .navigate(passEmail)


            var addingMoney = etMoneyAddAmt.text.toString().toDouble()
            viewModelGrow.getUserBalance().observe(viewLifecycleOwner, Observer {
                if (it != null){
                    addingMoney+=it.addMoney.toString().toDouble()
                }else{
                    addingMoney+=0.0
                }
            })

            val userModel = UserBalance(id = 1, addMoney = addingMoney)
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
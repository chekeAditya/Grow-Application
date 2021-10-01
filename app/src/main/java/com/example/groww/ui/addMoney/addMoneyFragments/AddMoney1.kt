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
            Navigation.findNavController(requireView())
                .navigate(passEmail)
        }



        addMoney1Btn.setOnClickListener {
            showMoneyToText()
            Navigation.findNavController(it).navigate(R.id.action_addMoney1_to_addMoney3)
        }

        viewModelGrow.getUserBalance().observe(viewLifecycleOwner, Observer {
            if (it != null){
                tvBalanceInAddMoneyFragment.text = "₹${it.addMoney}"
            }else{
                tvBalanceInAddMoneyFragment.text = "₹0.00"
            }
        })
    }

    private fun showMoneyToText() {
        val addingMoney = etMoneyAddAmt.text
        val userModel = UserBalance(id = 1, addMoney = addingMoney.toString().toDouble())
        viewModelGrow.insertMoney(userModel)
    }

}
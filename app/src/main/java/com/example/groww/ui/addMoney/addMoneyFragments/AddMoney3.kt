package com.example.groww.ui.addMoney.addMoneyFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.groww.R
import com.example.groww.ui.addMoney.explore.HomeActivity
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_money3.*

@AndroidEntryPoint
class AddMoney3 : Fragment(R.layout.fragment_add_money3) {

    val args1: AddMoney3Args by navArgs()
    val viewModelGrow: ViewModelGrow by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvAmountInPaymentSuccessfull.text = args1.amountAddMoney1

        viewModelGrow.getUserBalance().observe(viewLifecycleOwner, Observer {
            if(it != null){
                userBalanceAddMoney3.text = it.addMoney.toString()
            }else userBalanceAddMoney3.text = "₹ 0.00"
        })

        doneAddMoney3.setOnClickListener {
            val intent = Intent(activity,HomeActivity::class.java)
            startActivity(intent)
        }


    }

}
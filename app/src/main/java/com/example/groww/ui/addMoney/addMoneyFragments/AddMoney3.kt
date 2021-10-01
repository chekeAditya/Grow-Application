package com.example.groww.ui.addMoney.addMoneyFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.groww.R
import com.example.groww.ui.addMoney.addMoneyFragments.AddMoney2Args
import kotlinx.android.synthetic.main.fragment_add_money3.*

class AddMoney3 : Fragment(R.layout.fragment_add_money3) {

    val args1: AddMoney3Args by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvAmountInPaymentSuccessfull.text = args1.amountAddMoney1
    }

}
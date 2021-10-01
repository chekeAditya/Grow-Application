package com.example.groww.ui.addMoney.addMoneyFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_add_money2.*

class AddMoney2 : Fragment(R.layout.fragment_add_money2) {

    val args: AddMoney2Args by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val money = args.amountAddMoney
        tvAmountPayableAddMoney2.text = money
        val passEmail1 = AddMoney2Directions.actionAddMoney22ToAddMoney3(tvAmountPayableAddMoney2.text.toString())
        visibility()
        Navigation.findNavController(requireView()).navigate(passEmail1)

    }

    private fun visibility() {
        googlePayBtn.setOnClickListener {
            googlePayAdd.visibility = View.VISIBLE
            phonePayAdd.visibility = View.GONE
            netBankAdd.visibility = View.GONE
            upiIdAdd.visibility = View.GONE
            otherUpiAdd.visibility = View.GONE
        }

        phonePayBtn.setOnClickListener {
            googlePayAdd.visibility = View.GONE
            phonePayAdd.visibility = View.VISIBLE
            netBankAdd.visibility = View.GONE
            upiIdAdd.visibility = View.GONE
            otherUpiAdd.visibility = View.GONE
        }
        otherUpiBtn.setOnClickListener {
            googlePayAdd.visibility = View.GONE
            phonePayAdd.visibility = View.GONE
            netBankAdd.visibility = View.GONE
            upiIdAdd.visibility = View.GONE
            otherUpiAdd.visibility = View.VISIBLE
        }
        upiIdBtn.setOnClickListener {
            googlePayAdd.visibility = View.GONE
            phonePayAdd.visibility = View.GONE
            netBankAdd.visibility = View.GONE
            upiIdAdd.visibility = View.VISIBLE
            otherUpiAdd.visibility = View.GONE
        }

        netBankBtn.setOnClickListener {
            googlePayAdd.visibility = View.GONE
            phonePayAdd.visibility = View.GONE
            netBankAdd.visibility = View.VISIBLE
            upiIdAdd.visibility = View.GONE
            otherUpiAdd.visibility = View.GONE
        }
    }

}
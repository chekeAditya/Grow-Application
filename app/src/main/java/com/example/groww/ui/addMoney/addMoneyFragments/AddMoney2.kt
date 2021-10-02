package com.example.groww.ui.addMoney.addMoneyFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.groww.R
import com.example.groww.remote.local.UserBalance
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_money1.*
import kotlinx.android.synthetic.main.fragment_add_money2.*
@AndroidEntryPoint
class AddMoney2 : Fragment(R.layout.fragment_add_money2) {

    val args: AddMoney2Args by navArgs()
    val viewModelGrow: ViewModelGrow by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val money = args.amountAddMoney
        tvAmountPayableAddMoney2.text = money

        phonePayAdd.setOnClickListener {
            val passEmail1 = AddMoney2Directions.actionAddMoney22ToAddMoney3(money.toString())
            Navigation.findNavController(it).navigate(passEmail1)

//            Navigation.findNavController(it).navigate(R.id.action_addMoney22_to_addMoney3)
//            Toast.makeText(context,"add",Toast.LENGTH_SHORT).show()

            val userModel = UserBalance(id = 1, addMoney = money.toString().toDouble())
            viewModelGrow.insertMoney(userModel)
        }

//        googlePayBtn.setOnClickListener {
//            Toast.makeText(context,"button",Toast.LENGTH_SHORT).show()
//        }

        visibility()


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
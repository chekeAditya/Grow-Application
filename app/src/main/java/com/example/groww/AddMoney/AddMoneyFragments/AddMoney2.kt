package com.example.groww.AddMoney.AddMoneyFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_add_money2.*

class AddMoney2 : Fragment(R.layout.fragment_add_money2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
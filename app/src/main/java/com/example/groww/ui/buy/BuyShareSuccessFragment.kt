package com.example.groww.ui.buy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.groww.R
import com.example.groww.ui.addMoney.explore.HomeActivity
import kotlinx.android.synthetic.main.fragment_buy_share_success.*

class BuyShareSuccessFragment : Fragment(R.layout.fragment_buy_share_success) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnDone.setOnClickListener {
            startActivity(Intent(context,HomeActivity::class.java))
        }

    }

}
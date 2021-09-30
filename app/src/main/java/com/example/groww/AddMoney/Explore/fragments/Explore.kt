package com.example.groww.AddMoney.Explore.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.groww.AddMoney.AddMoney
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_explore_abhi.*


class Explore : Fragment(R.layout.fragment_explore_abhi) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addMoneyExplore.setOnClickListener {
            val intent  = Intent(activity,AddMoney::class.java)
            startActivity(intent)
        }

    }

}
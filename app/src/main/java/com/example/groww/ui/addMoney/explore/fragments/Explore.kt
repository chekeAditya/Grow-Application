package com.example.groww.ui.addMoney.explore.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.groww.R
import com.example.groww.ui.addMoney.AddMoney
import com.example.groww.viewmodel.ViewModelGrow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_explore_abhi.*

@AndroidEntryPoint
class Explore : Fragment(R.layout.fragment_explore_abhi) {

    val viewModelGrow: ViewModelGrow by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        addMoneyExplore.setOnClickListener {
            val intent = Intent(activity, AddMoney::class.java)
            startActivity(intent)
        }

        viewModelGrow.getUserBalance().observe(viewLifecycleOwner, Observer {
            if (it == null || it.addMoney < 1) {
                rlAddMoneyLayout.visibility = View.VISIBLE
            }else{
                rlAddMoneyLayout.visibility = View.GONE
            }
        })
    }
}
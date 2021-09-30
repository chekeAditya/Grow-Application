package com.example.groww.ui.buy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_buy_share.*

class BuyShareFragment : Fragment(R.layout.fragment_buy_share) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(requireView())

        btnShareBuy.setOnClickListener {
            navController.navigate(R.id.action_buyShareFragment_to_buyShareSuccessFragment)
        }
    }

}
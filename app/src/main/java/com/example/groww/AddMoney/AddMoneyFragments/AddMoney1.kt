package com.example.groww.AddMoney.AddMoneyFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_add_money1.*


class AddMoney1 : Fragment(R.layout.fragment_add_money1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addMoney1Btn.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_addMoney12_to_addMoney22)
        }
    }

}
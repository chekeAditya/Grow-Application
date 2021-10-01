package com.example.groww.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.groww.R
import kotlinx.android.synthetic.main.fragment_search_all.*

class SearchAllFragment : Fragment(R.layout.fragment_search_all) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(requireView())
        randomSearchView.setOnClickListener {
            navController.navigate(R.id.action_searchAllFragment_to_stockDetailsFragment)
        }
    }

}
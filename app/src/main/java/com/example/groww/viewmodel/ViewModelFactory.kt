package com.example.groww.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.groww.repopsitory.Repository

class ViewModelFactory(val repo: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelGrow(repo) as T
    }
}
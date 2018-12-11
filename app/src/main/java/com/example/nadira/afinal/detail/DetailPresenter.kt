package com.example.nadira.afinal.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.nadira.afinal.model.Person

class DetailPresenter(private var person: Person) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(person) as T
        throw IllegalArgumentException("Unknown viewModel class")
    }
}
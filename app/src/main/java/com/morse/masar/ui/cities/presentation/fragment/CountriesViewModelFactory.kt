package com.morse.masar.ui.cities.presentation.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.morse.masar.ui.cities.domain.GetCountriesData

class CountriesViewModelFactory (private var context: Context , private var fileName:String , private var useCase : GetCountriesData) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountriousViewModel(
            context,
            fileName,
            useCase
        ) as T
    }
}
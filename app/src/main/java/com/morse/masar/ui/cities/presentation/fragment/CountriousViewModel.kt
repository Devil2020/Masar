package com.morse.masar.ui.cities.presentation.fragment

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.morse.masar.ui.cities.domain.GetCountriesData
import com.morse.masar.ui.cities.model.entities.PlaceResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CountriousViewModel (private var context: Context ,
                           private var fileName : String ,
                           private var useCase: GetCountriesData) : ViewModel() {

    var getCountries = MutableLiveData<PlaceResponse>()

    fun getCountries () {
        CoroutineScope(Dispatchers?.Main)?.launch {
            useCase?.getCountries(context , fileName)?.collect {
                getCountries?.postValue(it!!)
            }
        }

    }

}
package com.morse.masar.ui.cities.domain

import android.content.Context
import com.morse.masar.ui.cities.model.CountriesRepository

class GetCountriesData ( private var repository: CountriesRepository) {

    public fun getCountries ( context: Context,  fileName : String) = repository?.getCountries(context, fileName)

}
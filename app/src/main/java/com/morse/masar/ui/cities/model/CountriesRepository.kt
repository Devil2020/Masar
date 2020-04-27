package com.morse.masar.ui.cities.model

import android.content.Context
import com.morse.masar.ui.cities.model.dataSource.AssestManager

class CountriesRepository (  private var assestManager: AssestManager) {

    public fun getCountries (context: Context,  fileName : String) = assestManager?.getCountries(context , fileName)


}
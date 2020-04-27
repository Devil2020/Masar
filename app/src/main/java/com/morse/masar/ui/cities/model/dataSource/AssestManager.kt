package com.morse.masar.ui.cities.model.dataSource

import android.content.Context
import com.google.gson.GsonBuilder
import com.morse.masar.ui.cities.model.entities.PlaceResponse
import kotlinx.coroutines.flow.flow

class AssestManager () {

 private fun getAssestData (context: Context , fileName : String) : String{
        var ourFileInputStream =  context?.assets?.open(fileName)
        var size = ourFileInputStream?.available()
        var buffer = ByteArray(size!!)
        ourFileInputStream?.read(buffer)
        ourFileInputStream?.close()
        return String(buffer)
  }

    fun getCountries (context: Context , fileName: String) = flow <PlaceResponse> {
        var countryData = getAssestData (context , fileName)
        var touristResponse =  GsonBuilder().create().fromJson(countryData , PlaceResponse::class.java)
        emit(touristResponse)
    }


}
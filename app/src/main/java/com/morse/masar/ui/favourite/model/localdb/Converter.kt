package com.morse.masar.ui.favourite.model.localdb

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.morse.masar.ui.cities.model.entities.Indoor
import com.morse.masar.ui.cities.model.entities.SliderImage


class Converter {

    @TypeConverter
    fun fromArrayListToStringSliderImage (listOfSlider : List<SliderImage>):String {
        return Gson().toJson(listOfSlider)?.toString()!!
    }

    @TypeConverter
    fun fromsStringToArraylistSliderImage (sliderImageString : String ) : List<SliderImage> {
       var listOfSliderImages : List<SliderImage> = Gson().fromJson(sliderImageString , Array<SliderImage>::class.java )?.toList()!!
        return listOfSliderImages
    }

    @TypeConverter
    fun fromArrayListToStringIndoorImage (listOfIndoor : List<Indoor>):String {
        return Gson().toJson(listOfIndoor)?.toString()!!
    }

    @TypeConverter
    fun fromsStringToArraylistIndoorImage (indoorImageString : String ) : List<Indoor> {
        var listOfSliderImages : List<Indoor> = Gson().fromJson(indoorImageString , Array<Indoor>::class.java)?.toList()!!
        return listOfSliderImages
    }
}
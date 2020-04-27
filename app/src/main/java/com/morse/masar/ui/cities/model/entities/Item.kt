package com.morse.masar.ui.cities.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val image: String,
    val name : String ,
    val map_image: String,
    val subcategorious: ArrayList<Subcategoriou>
) : Parcelable
package com.morse.masar.ui.cities.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categorious(
    val items: ArrayList<Item>,
    val map_image: String
) :Parcelable
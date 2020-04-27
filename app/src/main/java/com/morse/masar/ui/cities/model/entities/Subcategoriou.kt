package com.morse.masar.ui.cities.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Subcategoriou(
    val image: String,
    val indoor: ArrayList<Indoor>,
    val location: String,
    val name: String,
    val review: String,
    val slider_images: ArrayList<SliderImage>,
    val type: String,
    val who_built: String,
    val year: String
) : Parcelable
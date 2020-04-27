package com.morse.masar.ui.favourite.model.localdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.morse.masar.ui.cities.model.entities.Indoor
import com.morse.masar.ui.cities.model.entities.SliderImage
@Entity (tableName = "subCat")
data class Subcategorioy(
    @PrimaryKey (autoGenerate = true)
    val id :Int = 0,
    val image: String = "",
    val indoor: List<Indoor> = ArrayList<Indoor>(),
    val location: String = "",
    val name: String = "",
    val review: String = "",
    val slider_images: List<SliderImage>  = ArrayList<SliderImage>(),
    val type: String = "",
    val who_built: String = "",
    val year: String = ""
)
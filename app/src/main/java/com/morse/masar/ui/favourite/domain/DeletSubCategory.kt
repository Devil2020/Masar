package com.morse.masar.ui.favourite.domain

import com.morse.masar.ui.favourite.model.FavouriteRepo
import com.morse.masar.ui.favourite.model.localdb.Subcategorioy

class DeletSubCategory (var favouriteRepo: FavouriteRepo) {

    fun deletSubCategory (subcategorioyName: String) {
        favouriteRepo?.deletItem(subcategorioyName)
    }

}
package com.morse.masar.ui.favourite.domain

import com.morse.masar.ui.favourite.model.FavouriteRepo
import com.morse.masar.ui.favourite.model.localdb.Subcategorioy

class InsertNewItem (var favouriteRepo: FavouriteRepo) {


    public fun addSubCategory (subcategorioy: Subcategorioy) = favouriteRepo?.insertNewItem(subcategorioy)

}
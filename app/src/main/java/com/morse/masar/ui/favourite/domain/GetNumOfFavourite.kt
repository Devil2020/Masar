package com.morse.masar.ui.favourite.domain

import android.content.Context
import com.morse.masar.ui.favourite.model.FavouriteRepo

class GetNumOfFavourite (var favouriteRepo: FavouriteRepo) {

    fun getLengthOfFavouriteItems () = favouriteRepo?.getNumOfItems()

}
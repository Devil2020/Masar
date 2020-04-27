package com.morse.masar.ui.favourite.domain

import com.morse.masar.ui.favourite.model.FavouriteRepo

class GetAllFavouriteSubcategory (var favouriteRepo: FavouriteRepo) {

    public fun getAllItemsOfFavourite () = favouriteRepo?.getAllFavourite()

}
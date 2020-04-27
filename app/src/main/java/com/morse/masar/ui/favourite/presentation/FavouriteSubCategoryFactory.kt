package com.morse.masar.ui.favourite.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.morse.masar.ui.favourite.domain.GetAllFavouriteSubcategory
import com.morse.masar.ui.favourite.domain.GetNumOfFavourite
import com.morse.masar.ui.favourite.domain.InsertNewItem

class FavouriteSubCategoryFactory (var context: Context,
                                   var getNumOfFavourite: GetNumOfFavourite,
                                   var insertNewItem: InsertNewItem,
                                   var getAll : GetAllFavouriteSubcategory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavouriteViewModel (context ,getNumOfFavourite, insertNewItem, getAll) as T
    }
}
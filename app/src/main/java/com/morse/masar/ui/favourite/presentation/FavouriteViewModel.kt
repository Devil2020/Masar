package com.morse.masar.ui.favourite.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.morse.masar.ui.favourite.domain.GetAllFavouriteSubcategory
import com.morse.masar.ui.favourite.domain.GetNumOfFavourite
import com.morse.masar.ui.favourite.domain.InsertNewItem
import com.morse.masar.ui.favourite.model.localdb.Subcategorioy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavouriteViewModel (var context: Context ,
                          var getNumOfFavourite: GetNumOfFavourite ,
                          var insertNewItem: InsertNewItem ,
                          var getAll : GetAllFavouriteSubcategory) : ViewModel () {

    var numOfFavouriteItems = MutableLiveData<Long> ()
    var itemsOfFavourite = MutableLiveData<ArrayList<Subcategorioy>> ()

    fun getNumOfFavouriteItems () {
        CoroutineScope(Dispatchers.IO)?.launch {
            getNumOfFavourite?.getLengthOfFavouriteItems()?.collect {
                numOfFavouriteItems?.postValue(it)
            }
        }
    }

    fun insertNewSubCategory (subcategorioy: Subcategorioy) {
        insertNewItem?.addSubCategory(subcategorioy)
    }

    fun getAllFavouriteSubCategorious () {
        CoroutineScope(Dispatchers.IO)?.launch {
            getAll?.getAllItemsOfFavourite()?.collect {
                itemsOfFavourite?.postValue(it)
            }
        }
    }
}
package com.morse.masar.ui.favourite.model

import android.content.Context
import com.morse.masar.ui.favourite.model.localdb.Subcategorioy
import com.morse.masar.ui.favourite.model.localdb.SubcategoryDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FavouriteRepo (var context: Context) {

    public fun getNumOfItems () = flow<Long> {
        var length =  SubcategoryDatabase.dataBaseBuilder?.getInstance(context = context)?.getDaoInteractor()?.getLengthOfItems()
        this.emit(length)
    }

    public fun insertNewItem ( subcategorioy: Subcategorioy )  {
        SubcategoryDatabase.dataBaseBuilder?.getInstance(context = context)?.getDaoInteractor()?.insertIntoDB(subcategorioy)
    }

    public fun deletItem (subcategorioyName: String ) {
        SubcategoryDatabase.dataBaseBuilder?.getInstance(context = context)?.getDaoInteractor()?.deletIntoDB(subcategorioyName)
    }

    public fun getAllFavourite () = flow<ArrayList<Subcategorioy>> {
        var items =  SubcategoryDatabase.dataBaseBuilder?.getInstance(context = context)?.getDaoInteractor()?.selectIntoDb()
        this.emit(items as ArrayList<Subcategorioy>)
    }
}
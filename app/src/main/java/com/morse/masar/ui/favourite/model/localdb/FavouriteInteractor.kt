package com.morse.masar.ui.favourite.model.localdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouriteInteractor {
    @Insert
     fun insertIntoDB (subcategorioy: Subcategorioy)
    @Query ("Delete from subCat where name like :subcategorioyName")
     fun deletIntoDB (subcategorioyName: String)
    @Query("Select * from subCat")
    suspend fun selectIntoDb () : List<Subcategorioy>
    @Query ("Select count (*) from subCat")
    suspend fun getLengthOfItems () : Long
    @Query ("Select count(*) from subCat where name like :name")
    suspend fun checkIfExists ( name : String ) : Long
}
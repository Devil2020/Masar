package com.morse.masar.ui.favourite.model.localdb

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(Subcategorioy::class) , version = 1)
@TypeConverters (Converter::class)
abstract class SubcategoryDatabase : RoomDatabase() {

    abstract fun getDaoInteractor () : FavouriteInteractor
    object dataBaseBuilder  {
        @Volatile var subcategorioyDB : SubcategoryDatabase? = null
        fun getInstance (context: Context) = subcategorioyDB ?: synchronized( this ){
            subcategorioyDB ?: buildDataBase (context)
        }
        private fun buildDataBase (context: Context) = Room.databaseBuilder(context ,SubcategoryDatabase::class.java , "masar.db")
            .build()
    }


}
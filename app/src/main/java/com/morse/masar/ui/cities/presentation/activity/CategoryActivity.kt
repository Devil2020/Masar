package com.morse.masar.ui.cities.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.morse.masar.R
import com.morse.masar.ui.cities.presentation.fragment.CitiesFragment
import com.morse.masar.ui.favourite.presentation.FavouriteFragment
import com.morse.masar.ui.info.InformationFragment
import kotlinx.android.synthetic.main.activity_category.*



public fun CategoryActivity.navigateTo (position : Int){
    var fragmentManager = supportFragmentManager
    when (position) {
        1 -> {
           var citiesFragment = fragmentManager?.findFragmentByTag("CitiesFragment")
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentsContainer ,
                if (citiesFragment != null) citiesFragment else CitiesFragment()  ,"CitiesFragment")
                ?.addToBackStack("CitiesFragment") ?.commit()
        }
        2 -> {
            var favouriteFragment = fragmentManager?.findFragmentByTag("FavouriteFragment")
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentsContainer ,
                if (favouriteFragment != null) favouriteFragment else FavouriteFragment(),"FavouriteFragment")
                ?.addToBackStack("FavouriteFragment")  ?.commit()
        }
        3 ->{
            var informationFragment = fragmentManager?.findFragmentByTag("InformationFragment")
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentsContainer ,
                if (informationFragment != null) informationFragment else InformationFragment() ,"InformationFragment")
                ?.addToBackStack("InformationFragment")?.commit()
        }
    }
}

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        navigateTo(1)
        bottomNavigator?.setOnNavigationItemSelectedListener {
            if (it?.itemId == R.id.cities){
                navigateTo(1)
                return@setOnNavigationItemSelectedListener true
            }
            else if (it?.itemId == R.id.favourities){
                navigateTo(2)
                return@setOnNavigationItemSelectedListener true
            }
            else {
                navigateTo(3)
            }
        false
        }
    }

}

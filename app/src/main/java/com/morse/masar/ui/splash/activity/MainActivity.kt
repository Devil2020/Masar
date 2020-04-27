package com.morse.masar.ui.splash.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.viewpager2.widget.ViewPager2
import com.morse.masar.R
import com.morse.masar.ui.cities.presentation.activity.CategoryActivity
import com.morse.masar.ui.splash.fragments.SplashScreenAdapter
import com.morse.masar.ui.core.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var checkSharedPreference : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkSharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        var isFirstTime = checkSharedPreference?.getBoolean("isFirstTime" , false)
        if (isFirstTime == false) {
            splashViewPager.adapter =
                SplashScreenAdapter(this , 3)

        }
        else {
            startActivity(Intent(
                this , CategoryActivity::class.java
            ))
        }
        splashViewPager.setPageTransformer(
            ZoomOutPageTransformer()
        )
        splashViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })
        dots_indicator.setViewPager2(splashViewPager)
    }

    override fun onResume() {
        super.onResume()

    }
}
